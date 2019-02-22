package com.website.springmvc.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Cart;
import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.Receipt;
import com.website.springmvc.entities.ReceiptItem;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.ReceiptItemService;
import com.website.springmvc.service.ReceiptService;
import com.website.springmvc.service.UserService;

@Controller
@RequestMapping(value = "cart")
public class Cartcontroller {
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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String cart(Model model) {
		model.addAttribute("user",userService.findByemail(getPrincipal()));
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("receipt", new Receipt());
		return "cart";
	}
	@RequestMapping(value = "checkout.html", method = RequestMethod.GET)
    public String viewCheckout(ModelMap mm, HttpSession session) {
        mm.put("listCategory", categoryService.getAll());
        showMyCart(session);
        mm.put("receipt", new Receipt());
        return "checkout";
    }

    private void showMyCart(HttpSession session) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        double count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", count);
        session.setAttribute("myCartNum", cartItems.size());
    }
	

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String viewAdd(ModelMap mm, HttpSession session, @RequestParam("id") long id) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.get(id);
        if (product != null) {
            if (cartItems.containsKey(id)) {
                Cart item = cartItems.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(id, item);
            }
        }
        int myCartNum = 0;
        
        
        for(Entry<Long, Cart> i: cartItems.entrySet()){
        	myCartNum =myCartNum+ i.getValue().getQuantity();
        }
        
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", myCartNum);
        
		
        return "redirect:/products" ;
       
    }
    @RequestMapping(value = "buynow", method = RequestMethod.GET)
    public String buynow(ModelMap mm, HttpSession session, @RequestParam("id") long id) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.get(id);
        if (product != null) {
            if (cartItems.containsKey(id)) {
                Cart item = cartItems.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(id, item);
            }
        }
        int myCartNum = 0;
        
        
        for(Entry<Long, Cart> i: cartItems.entrySet()){
        	myCartNum =myCartNum+ i.getValue().getQuantity();
        }
        
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", myCartNum);
        
        
		
        return "redirect:/cart" ;
       
    }
 
    @RequestMapping(value = "sub/{id}.html", method = RequestMethod.GET)
    public String viewUpdate(ModelMap mm, HttpSession session, @PathVariable("id") long productId) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
        return "cart";
    }
 
    @RequestMapping(value = "remove/{id}.html", method = RequestMethod.GET)
    public String viewRemove(ModelMap mm, HttpSession session, @PathVariable("id") long id) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(id)) {
            cartItems.remove(id);
        }        
        
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/cart";
    }
    
    @RequestMapping(value = "accept", method = RequestMethod.GET)
    public String viewacept(ModelMap mm, HttpSession session) {
            HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
            
            Receipt receipt = (Receipt) session.getAttribute("receipt");
            if (cartItems == null) {
                cartItems = new HashMap<>();
            }
            
            receipt.setReceiptDate(new Timestamp(new Date().getTime()));
            receipt.setReceiptStatus(true);
            receiptService.create(receipt);
            for (Map.Entry<Long, Cart> entry : cartItems.entrySet()) {
                ReceiptItem receiptItem = new ReceiptItem();
                receiptItem.setReceiptId(receipt.getReceiptId());
                receiptItem.setProduct(entry.getValue().getProduct());
                receiptItem.setReceiptItemPrice(entry.getValue().getProduct().getPrice());
                receiptItem.setReceiptItemQuantity(entry.getValue().getQuantity());
                receiptItem.setReceiptItemStatus(true);
                receiptItemService.create(receiptItem);
            }
            cartItems = new HashMap<>();
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("myCartTotal", 0);
            session.setAttribute("myCartNum", 0);
            return "shoppingsuccess";
    }
    
    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String viewCheckout(ModelMap mm, HttpSession session, @ModelAttribute("receipt") Receipt receipt) {
            HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
            if (cartItems == null) {
                cartItems = new HashMap<>();
            }                    
            mm.addAttribute("loggedinuser", getPrincipal());
            session.setAttribute("receipt", receipt);
            return "CheckoutForm";
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("receiptItem") ReceiptItem receiptItem) {
    	if(receiptItem.getReceiptItemId() != 0L) {
    		receiptItemService.create(receiptItem);
    	}
    	return "checkout";
    }
 
    public double totalPrice(HashMap<Long, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        return count;
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
