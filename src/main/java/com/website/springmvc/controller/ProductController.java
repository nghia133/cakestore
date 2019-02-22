package com.website.springmvc.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Cart;
import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Product;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;

@Controller
@RequestMapping(value = "/")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String viewProductList(ModelMap mm) {
    	mm.put("loggedinuser", getPrincipal());
        mm.put("products", productService.getListNav(0, 6));
        int pages = (int) Math.ceil(productService.totalItem()/6);
        mm.put("totalItem", pages);
        mm.put("categories", categoryService.getAll());        
        return "product";
    }
    
    @RequestMapping(value = "/productlist", method = RequestMethod.GET)
    public String viewProduct(ModelMap mm) {
    	mm.put("loggedinuser", getPrincipal());
        mm.put("products", productService.GetAll());        
        mm.put("categories", categoryService.getAll());
        return "productlist";
    }


	@RequestMapping(value = "products-{page}", method = RequestMethod.GET)
	public String viewProductListByPage(ModelMap mm, @PathVariable("page") int page) {
	      mm.put("products", productService.getListNav((page-1)*6,6));
	      int pages = (int) Math.ceil(productService.totalItem()/6);
	       mm.put("totalItem", pages);
	      mm.put("categories", categoryService.getAll());	      
	      mm.put("loggedinuser", getPrincipal());
	      return "product";

	}	
	
	@RequestMapping(value="category", method = RequestMethod.GET)
	public ModelAndView getcategory(@RequestParam("id") Long id, ModelAndView model)
	{		
		model.addObject("name", categoryService.get(id).getname());
		int pages = (int) Math.ceil(productService.totalItembyCategory(id)/6);
		model.addObject("totalItem", pages);
		model.setViewName("productcategory");
		model.addObject("id", id);
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("products",productService.getListByCategory(id, 0,6));
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	
	@RequestMapping(value="listcategory", method = RequestMethod.GET)
	public ModelAndView getlistcategory(@RequestParam("id") Long id, ModelAndView model)
	{		
		
		model.addObject("name", categoryService.get(id).getname());
		model.setViewName("productlist");
		model.addObject("id", id);
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("products",productService.getAllByCategory(id));
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	
	@RequestMapping(value="category{id}-{page}", method = RequestMethod.GET)
	public ModelAndView getcategorypage( @PathVariable("id") Long id, @PathVariable("page") int page,ModelAndView model)
	{			
		int pages = (int) Math.ceil(productService.totalItembyCategory(id)/6);
		model.addObject("name", categoryService.get(id).getname());
		model.addObject("totalItem", pages);
		model.setViewName("productcategory");
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("products",productService.getListByCategory(id, (page-1)*6,6));
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	
	@RequestMapping(value = "addproduct", method = RequestMethod.GET)
	public ModelAndView addProduct(ModelAndView model) {
		model.addObject("loggedinuser", getPrincipal());
		model.setViewName("productDetail");
		model.addObject("edit",false);
		model.addObject("categories", categoryService.getAll());
		model.addObject("product", new Product());
		return model;
	}
	
	@RequestMapping(value = "addcategory", method = RequestMethod.GET)
	public ModelAndView addcategory(ModelAndView model) {		
		model.setViewName("editcategory");				
		model.addObject("category", new Category());
		return model;
	}
	
	@RequestMapping(value = "addcategory", method = RequestMethod.POST)
	public String addcategory( @ModelAttribute("category") Category category) 
	{	

		categoryService.add(category);
		return "redirect:/productlist";
		
	}
	
	@RequestMapping(value = "saveproduct", method = RequestMethod.POST)
	public String save( @ModelAttribute("product") Product product,BindingResult result, @RequestParam CommonsMultipartFile image) throws IOException
	{			
		if(productService.GetAll().isEmpty()){
			product.setImage(image.getBytes());	
			productService.add(product);
			return "redirect:/productlist";
		}
		
		for(Product i: productService.GetAll()){
		if(i.getId()==product.getId()){
		if (image.isEmpty()){
			product.setImage(productService.get(product.getId()).getImage());				
			productService.update(product);	
			return "redirect:/productlist";
		}		
		product.setImage(image.getBytes());	
		productService.update(product);	
		return "redirect:/productlist";
		
		}
		product.setImage(image.getBytes());	
		productService.add(product);
		return "redirect:/productlist";
		}
		return "redirect:/productlist";
	}
	
      
	
	 
	@RequestMapping(value = "viewproduct", method = RequestMethod.GET)
	public String getProduct(@RequestParam("id") Long id, ModelMap mm) {
		mm.put("loggedinuser", getPrincipal());		
		mm.put("product", productService.get(id));		
		return "detail";		
	}
	
	@RequestMapping(value = "imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


	    Product item = productService.get(itemId);        
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif,image/pjpeg");
	    response.getOutputStream().write(item.getImage());


	    response.getOutputStream().close();	
	}
	
	@RequestMapping(value = "editproduct", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam("id") Long id, ModelAndView model) {		
		model.setViewName("productDetail");
		model.addObject("edit", true);
		model.addObject("categories", categoryService.getAll());
		model.addObject("product", productService.get(id));		
		return model;
	}
	
	@RequestMapping(value = "deleteproduct", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long id) {		
		productService.delete(id);
		return "redirect:/productlist";
	}
	
	/*@RequestMapping(value="products-addImage", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session, ModelAndView model) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		System.out.println(path+""+filename);
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path+"/"+filename));
			Object o= bout;
			bout.write(barr);
			bout.flush();
			bout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}*/
	
	

	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search( ModelAndView model,@RequestParam(value = "keyword") String keyword) {
		if(keyword.isEmpty()){
			model.setViewName("product");
			model.addObject("loggedinuser", getPrincipal());
			model.addObject("products",productService.GetAll());
			model.addObject("categories", categoryService.getAll());
			return model;
		}
		model.setViewName("product");
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("products",productService.search(keyword));
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
}
}
