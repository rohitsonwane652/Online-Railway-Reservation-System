package com.casestudy.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.casestudy.model.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {
	
	private static final String KEY = "rzp_test_t21DtQ1cuKqDIW";
	private static final String KEY_SECRET = "A3tPXq7TgN7meE4lad1uRifU";
	private static final String CURRENCY = "INR";
	
	public TransactionDetails createTransaction(double amount) {
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount*100));
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY,KEY_SECRET);
			
			Order order =  razorpayClient.orders.create(jsonObject);
			
			TransactionDetails transaction =  prepareTransactionDetails(order);
			
			return transaction;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private TransactionDetails prepareTransactionDetails(Order order ) {
		String orderId = order.get("id");
		String currency = order.get("currency");
		Integer amount = order.get("amount");
		
		return new TransactionDetails(orderId,currency,amount,KEY);
		
	}
	
}
