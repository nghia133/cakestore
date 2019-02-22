package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.Dao;
import com.website.springmvc.entities.Category;


@Transactional
@Service
public class CategoryService {
	@Autowired
	Dao<Category> categoryDao;
	
	public List<Category> getAll(){
		return categoryDao.getAll();
	}
	
	public Category get(Long id){
		return categoryDao.get(id);
	}
	
	public Category add(Category category){
		return categoryDao.add(category);
	}
	
	public Boolean update(Category category){
		return categoryDao.update(category);
	}
	
	public Boolean delete(Category category){
		return categoryDao.delete(category);
	}
	
	public Boolean delete(Long id){
		return categoryDao.delete(id);
	}

}
