	package com.website.springmvc.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;
import com.website.springmvc.entities.UserProfile;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.UserProfileService;
import com.website.springmvc.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * This method will list all existing users.
	 * 
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		try {
			productService.indexProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("loggedinuser", getPrincipal());		
		return "home";
	}
	
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}
	
	

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap model) {
		if (isCurrentAuthenticationAnonymous()) {	    
		User user = new User();
		model.addAttribute("user", user);
		
		return "registration";
		}else 
	    	return "home";
	}
	
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String saveregister(@Valid User user, BindingResult result,
			ModelMap model) {
		
		if(!userService.isUseremailUnique(user.getId(), user.getEmail())){
			FieldError ssoError =new FieldError("user","email",messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User" + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "home";
	}
	
	@RequestMapping(value = { "edit" }, method = RequestMethod.GET)
	public String edit(ModelMap model) {
		User user = userService.findByemail(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		
		return "useredit";
	}
	
	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String update(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "useredit";
		}

		userService.updateUser(user);

		
		model.addAttribute("loggedinuser", getPrincipal());
		return "home";
	}

	
	
	@RequestMapping(value = { "newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		
		return "registration";
	}
	
	@RequestMapping(value = { "newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, 
			ModelMap model) {		
		if(!userService.isUseremailUnique(user.getId(), user.getEmail())){
			FieldError ssoError =new FieldError("user","email",messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User" + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	
	@RequestMapping(value = { "/edit-user-{email}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String email, ModelMap model) {
		User user = userService.findByemail(email);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "edituser";
	}	
	
	
	@RequestMapping(value = { "/edit-user-{email}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String email) {

		if (result.hasErrors()) {
			return "edituser";
		}

		userService.updateUser(user);

		model.addAttribute("success", "User " + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/edit-pass-{email}" }, method = RequestMethod.GET)
	public String editpass(@PathVariable String email, ModelMap model) {
		
		model.addAttribute("userx", new User());
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "editpass";
	}	
	
	
	@RequestMapping(value = { "/edit-pass-{email}" }, method = RequestMethod.POST)
	public String updatepass(@ModelAttribute("userx") User userx, BindingResult result,
			ModelMap model, @PathVariable String email) {
		User user = userService.findByemail(email);
		if (result.hasErrors()) {
			return "editpass";
		}
		user.setPassword(userx.getPassword());
		userService.updatepass(user);

		model.addAttribute("success", "User " + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "passsuccess";
	}
	
	@RequestMapping(value = { "/editpass" }, method = RequestMethod.GET)
	public String usereditpass( ModelMap model) {
		
		model.addAttribute("userx",new User());
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "editpass";
	}	
	
	
	@RequestMapping(value = { "/editpass" }, method = RequestMethod.POST)
	public String userupdatepass(@ModelAttribute("userx") User userx, BindingResult result,
			ModelMap model) {
		User user = userService.findByemail( getPrincipal());
		
		if (result.hasErrors()) {
			return "editpass";
		}
		user.setPassword(userx.getPassword());
		userService.updatepass(user);

		model.addAttribute("success", "User " + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "passsuccess";
	}

	
	
	@RequestMapping(value = { "/delete-user-{email}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String email) {
		userService.deleteUserByemail(email);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "home";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
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
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}