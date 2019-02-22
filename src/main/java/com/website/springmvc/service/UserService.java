package com.website.springmvc.service;

import java.util.List;

import com.website.springmvc.entities.User;




public interface UserService {
	
	User findById(int id);
	
	User findByemail(String email);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void updatepass(User user);
	
	void deleteUserByemail(String email);

	List<User> findAllUsers(); 
	
	boolean isUseremailUnique(Integer id, String email);

}