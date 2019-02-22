package com.website.springmvc.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "receipt")
public class Receipt implements Serializable {

    @Id
    @GeneratedValue
    private long receiptId;
    private String receiptName;
    private String receiptphone;
    private String receiptAddress;
    private Timestamp receiptDate;
    private double receiptPay;
    private boolean receiptStatus;    
   
    
	public Receipt() {
		
	}
	
	public Receipt(long receiptId, String receiptName, String receiptphone, String receiptAddress, Timestamp receiptDate,
			boolean receiptStatus, double receiptPay) {
		this.receiptId = receiptId;
		this.receiptName = receiptName;
		this.receiptphone = receiptphone;
		this.receiptAddress = receiptAddress;
		this.receiptDate = receiptDate;
		this.receiptStatus = receiptStatus;
		
		this.receiptPay = receiptPay;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public String getReceiptphone() {
		return receiptphone;
	}

	public void setReceiptphone(String receiptphone) {
		this.receiptphone = receiptphone;
	}

	public String getReceiptAddress() {
		return receiptAddress;
	}

	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}

	public Timestamp getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Timestamp receiptDate) {
		this.receiptDate = receiptDate;
	}

	public boolean isReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(boolean receiptStatus) {
		this.receiptStatus = receiptStatus;
	}	

	public double getReceiptPay() {
		return receiptPay;
	}

	public void setReceiptPay(double receiptPay) {
		this.receiptPay = receiptPay;
	}

	
    
    
}

