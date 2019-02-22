package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;


import com.website.springmvc.entities.Receipt;

public interface ReceiptService {
    
    // create
    public boolean create(Receipt object);

    // update
    public boolean update(Receipt object);

    // delete
    public boolean delete(Receipt object);

    // find by id
    public Receipt findById(long receiptId);

    // load list receipt
    public List<Receipt> getAll();
    
}
