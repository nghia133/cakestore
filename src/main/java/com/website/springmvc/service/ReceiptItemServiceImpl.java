package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.ReceiptItemDAO;
import com.website.springmvc.entities.ReceiptItem;

@Transactional
@Service
public class ReceiptItemServiceImpl implements ReceiptItemService {

    @Autowired
    private ReceiptItemDAO receiptItemDAO;

    @Override
    public boolean create(ReceiptItem object) {
        return receiptItemDAO.create(object);
    }

    @Override
    public boolean update(ReceiptItem object) {
        return receiptItemDAO.update(object);
    }

    @Override
    public boolean delete(ReceiptItem object) {
        return receiptItemDAO.delete(object);
    }

    @Override
    public ReceiptItem findById(Long receiptItemId) {
        return receiptItemDAO.findById(receiptItemId);
    }

    @Override
    public List<ReceiptItem> getListByReceipt(long getListByReceipt) {
        return receiptItemDAO.getListByReceipt(getListByReceipt);
    }

	@Override
	public List<ReceiptItem> GetAll() {
		
		return receiptItemDAO.GetAll();
	}
    

}