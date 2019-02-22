package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.website.springmvc.entities.Receipt;

public interface ReceiptDAO {
    
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
