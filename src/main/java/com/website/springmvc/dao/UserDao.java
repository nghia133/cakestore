package com.website.springmvc.dao;

import java.util.List;

import com.website.springmvc.entities.User;


public interface UserDao {

	User findById(int id);
	
	User findByemail(String email);
	
	void save(User user);
	
	void deleteByemail(String email);
	
	List<User> findAllUsers();

}

