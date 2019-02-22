package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.website.springmvc.dao.ProductDAO;
import com.website.springmvc.entities.Product;

@Transactional
@Service
public class ProductService {
	@Autowired
	ProductDAO<Product> productDao;
	
	public List<Product> GetAll(){
		return productDao.getAll();
	}
	
	public List<Product> getAllByCategory(Long id){
		return productDao.getAllByCategory(id);
	}
	
	public Product get(Long id) {
		return productDao.get(id);
	}
	
	public Product add(Product product) {
		return productDao.add(product);	
	}
	
	public Boolean update(Product product) {
		return productDao.update(product);
	}
	public Boolean delete(Product product) {
		return productDao.delete(product);
	}
	public Boolean delete(Long id) {
		return productDao.delete(id);
	}

	public List<Product> getListNav(int start, int limit) {
		// TODO Auto-generated method stub
		return productDao.getListNav(start, limit);
	}
	
	public List<Product> getListByCategory(Long id,int start, int limit){
		return productDao.getListByCategory(id, start, limit);
	}

	public Long totalItem() {		
		return productDao.totalItem();		
	}
	
	public Long totalItembyCategory(Long id){
		return productDao.totalItembyCategory(id);
	}
	
	public List<Product> search(String keyword){
		return productDao.search(keyword);
	}
	public void indexProduct() throws Exception {
		productDao.indexProduct();
	}
}
