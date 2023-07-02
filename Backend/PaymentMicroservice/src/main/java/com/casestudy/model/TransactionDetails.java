package com.casestudy.model;

public class TransactionDetails {
	
	private String orderId;
	private String currency;
	private Integer amount;
	private String key;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String curency) {
		this.currency = curency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public TransactionDetails(String orderId, String currency, Integer amount, String key) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
		this.key = key;
	}
	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
