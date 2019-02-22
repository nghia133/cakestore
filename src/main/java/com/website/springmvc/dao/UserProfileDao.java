package com.website.springmvc.dao;

import java.util.List;

import com.website.springmvc.entities.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
