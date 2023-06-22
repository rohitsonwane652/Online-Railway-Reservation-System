package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.TransactionDetails;
import com.casestudy.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/createTransaction")
	public TransactionDetails createTransaction(@RequestParam final double amount) {
		return paymentService.createTransaction(amount);
	}
}
