package com.website.springmvc.service;

import java.util.List;

import com.website.springmvc.entities.ReceiptItem;
public interface ReceiptItemService {
    
	// create
	public boolean create(ReceiptItem object);

	// update
	public boolean update(ReceiptItem object);

	// delete
	public boolean delete(ReceiptItem object);

	// find by id
	public ReceiptItem findById(Long receiptItemId);

	// load list receipt item
	public List<ReceiptItem> getListByReceipt(long receiptId);
	
	public List<ReceiptItem> GetAll();
	
}
