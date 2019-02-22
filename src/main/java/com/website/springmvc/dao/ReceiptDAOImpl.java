package com.website.springmvc.dao;


import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Receipt;
import com.website.springmvc.entities.ReceiptItem;


@Repository
public class ReceiptDAOImpl implements ReceiptDAO {
	@Autowired
	private SessionFactory sessionfactory;

    @Override
    public boolean create(Receipt object) {
    	Session session = this.sessionfactory.getCurrentSession();          
        try {           
            session.save(object);            
            return Boolean.TRUE;
        } catch (Exception ex) {
        	return Boolean.FALSE;
            }
            
    }

    @Override
    public boolean update(Receipt object) {
    	Session session = this.sessionfactory.getCurrentSession();   
        
        try {           
            session.update(object);
            return Boolean.TRUE;
        } catch (Exception ex) {
        	return Boolean.FALSE;
            }
            
    }

    @Override
    public boolean delete(Receipt object) {
    	Session session = this.sessionfactory.getCurrentSession();  
       
        try {
           
            session.delete(object);
            return Boolean.TRUE;
        } catch (Exception ex) {
           
            	return Boolean.FALSE;
        } 
    }
    @Override
    public Receipt findById(long receiptId) {
    	Session session = this.sessionfactory.getCurrentSession();         
            Query query = session.createQuery("FROM receipt WHERE receiptId = :receiptId");
            query.setLong("receiptId", receiptId);
            Receipt obj = (Receipt) query.uniqueResult();            
            return obj;        
    }

    @Override
    public List<Receipt> getAll() {
    	Session session = this.sessionfactory.getCurrentSession();        
            Query query = session.createQuery("from receipt");
            List<Receipt> list = query.list();           
            return list;
       
    }

   
}