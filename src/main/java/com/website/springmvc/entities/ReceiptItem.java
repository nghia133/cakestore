package com.website.springmvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "receiptitem")
public class ReceiptItem implements Serializable {

    @Id
    @GeneratedValue
    private long receiptItemId;
   
    private long receiptId;
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int receiptItemQuantity;
    private double receiptItemPrice;
    private int receiptItemSale;
    private boolean receiptItemStatus;
    
	public ReceiptItem() {

	}

	public ReceiptItem(long receiptItemId, long receiptId, Product product, int receiptItemQuantity,
			double receiptItemPrice, int receiptItemSale, boolean receiptItemStatus) {
		this.receiptItemId = receiptItemId;
		this.receiptId = receiptId;
		this.product = product;
		this.receiptItemQuantity = receiptItemQuantity;
		this.receiptItemPrice = receiptItemPrice;
		this.receiptItemSale = receiptItemSale;
		this.receiptItemStatus = receiptItemStatus;
	}

	public long getReceiptItemId() {
		return receiptItemId;
	}

	public void setReceiptItemId(long receiptItemId) {
		this.receiptItemId = receiptItemId;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getReceiptItemQuantity() {
		return receiptItemQuantity;
	}

	public void setReceiptItemQuantity(int receiptItemQuantity) {
		this.receiptItemQuantity = receiptItemQuantity;
	}

	public double getReceiptItemPrice() {
		return receiptItemPrice;
	}

	public void setReceiptItemPrice(double receiptItemPrice) {
		this.receiptItemPrice = receiptItemPrice;
	}
	
	public int getReceiptItemSale() {
		return receiptItemSale;
	}

	public void setReceiptItemSale(int receiptItemSale) {
		this.receiptItemSale = receiptItemSale;
	}

	public boolean isReceiptItemStatus() {
		return receiptItemStatus;
	}

	public void setReceiptItemStatus(boolean receiptItemStatus) {
		this.receiptItemStatus = receiptItemStatus;
	}
	
    
    
    
}