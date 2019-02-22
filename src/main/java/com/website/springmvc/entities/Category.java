package com.website.springmvc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category", catalog = "cakestore")
public class Category {

	private Long id;	
	private String name;
	Collection<Product> products;
	
	
	
	public Category() {
		
	}



	public Category(Long id, String name) {
		
		this.id = id;
		this.name = name;		
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
	
	@Column(name = "CATEGORY_NAME", length = 50)
	public String getname() {
		return name;
	}


	
	public void setname(String name) {
		this.name = name;
	}


	@OneToMany(mappedBy="category")
	public Collection<Product> getProducts() {
		return products;
	}



	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
	
	
}
 