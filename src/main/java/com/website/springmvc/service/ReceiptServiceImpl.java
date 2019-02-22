package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.ReceiptDAO;
import com.website.springmvc.entities.Receipt;

@Transactional
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptDAO receiptDAO;

    @Override
    public boolean create(Receipt object) {
        return receiptDAO.create(object);
    }

    @Override
    public boolean update(Receipt object) {
        return receiptDAO.update(object);
    }

    @Override
    public boolean delete(Receipt object) {
        return receiptDAO.delete(object);
    }

    @Override
    public Receipt findById(long receiptId) {
        return receiptDAO.findById(receiptId);
    }

    @Override
    public List<Receipt> getAll() {
        return receiptDAO.getAll();
    }

}