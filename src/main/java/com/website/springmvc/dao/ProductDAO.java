package com.website.springmvc.dao;

import java.util.List;

import com.website.springmvc.entities.Product;

public abstract class ProductDAO<T> {
	
	public abstract List<T> getAll();

	public abstract T get(Long id);

	public abstract T add(T t);

	public abstract Boolean update(T t);

	public abstract Boolean delete(T t);

	public abstract Boolean delete(Long id);
	
	public abstract List<T> getListNav(int start, int limit);
	
	public abstract List<T> getListByCategory(Long id, int start, int limit);

	public abstract Long totalItem();

	public abstract Long totalItembyCategory(Long id);

	public abstract List<T> getAllByCategory(Long id) ;

	public abstract List<T> search(String keyword) ;

	public abstract void indexProduct() throws Exception ;
		
		
		
		
	
		

}
