package com.casestudy.model;

public class TransactionDetails {
	
	private String orderId;
	private String currency;
	private Integer amount;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurency() {
		return currency;
	}
	public void setCurency(String curency) {
		this.currency = curency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public TransactionDetails(String orderId, String curency, Integer amount) {
		super();
		this.orderId = orderId;
		this.currency = curency;
		this.amount = amount;
	}
	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
