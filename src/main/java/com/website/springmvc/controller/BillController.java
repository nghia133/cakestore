package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.ReceiptItem;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.ReceiptItemService;
import com.website.springmvc.service.ReceiptService;
import com.website.springmvc.service.UserService;

@Controller
@RequestMapping(value = "bill")
public class BillController {
	@Autowired
	UserService userService;
	
	@Autowired
    private ProductService productService;
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private ReceiptItemService receiptItemService;
	@Autowired
    private CategoryService categoryService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView getReceipt(ModelAndView model) {
		model.addObject("loggedinuser", getPrincipal());
		model.setViewName("bills");
		model.addObject("receipt", receiptService.getAll());    	
		return model;	
}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String getReceiptItem(@RequestParam("id") Long receiptId) {		
		for(ReceiptItem i:receiptItemService.getListByReceipt(receiptId)){
			receiptItemService.delete(i);
		}
		
		receiptService.delete(receiptService.findById(receiptId));
		 	
		return "redirect:/bill";	
		
}
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView view(ModelAndView model,@RequestParam("id") Long receiptId) {
		model.addObject("loggedinuser", getPrincipal());
		model.setViewName("billdetail");
		model.addObject("receipt", receiptService.findById(receiptId));  
		model.addObject("receiptitem", receiptItemService.getListByReceipt(receiptId));    
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
