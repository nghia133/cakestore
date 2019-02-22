package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.ReceiptItem;


@Repository
public class ReceiptItemDAOImpl implements ReceiptItemDAO {
	@Autowired
	private SessionFactory sessionfactory;
    @Override
    public boolean create(ReceiptItem object) {
    	Session session = this.sessionfactory.getCurrentSession();
       
        try {
            
            session.save(object);
            return Boolean.TRUE;
        } catch (Exception ex) {
        	return Boolean.FALSE;
            }
            
    }

    @Override
    public boolean update(ReceiptItem object) {
    	Session session = this.sessionfactory.getCurrentSession();
      
        try {
           
            session.update(object);
            return Boolean.TRUE;
        } catch (Exception ex) {
        	return Boolean.FALSE;
            }
           
    }

    @Override
    public boolean delete(ReceiptItem object) {
    	Session session = this.sessionfactory.getCurrentSession();
        
        try {
           
            session.delete(object);
            return Boolean.TRUE;
        } catch (Exception ex) {
        	return Boolean.FALSE;
            }
            
    }

    @Override
    public ReceiptItem findById(long receiptItemId) {
    	Session session = this.sessionfactory.getCurrentSession();       
            Query query = session.createQuery("FROM receiptitem WHERE receiptItemId = :receiptItemId");
            query.setLong("receiptItemId", receiptItemId);
            ReceiptItem obj = (ReceiptItem) query.uniqueResult();           
            return obj;
        
    }

    @Override
    public List<ReceiptItem> getListByReceipt(long receiptId) {
    	Session session = this.sessionfactory.getCurrentSession();           
            Query query = session.createQuery("FROM receiptitem WHERE receiptId = :receiptId");
            query.setLong("receiptId", receiptId);
            List<ReceiptItem> list = query.list();           
            return list;       
    }

	@Override
	public List<ReceiptItem> GetAll() {
		Session session = this.sessionfactory.getCurrentSession();    	
    		Query query = session.createQuery("From receiptitem");
    		List<ReceiptItem> list = query.list();
    		 return list;  
    		
	}
	

}