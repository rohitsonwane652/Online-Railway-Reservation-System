package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.client.TrainDetailProxy;
import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;
import com.casestudy.service.BookingService;
import com.casestudy.util.TrainInfoDto;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/acticket")
	public TrainTicket bookAcTicket(@RequestBody PassengerInfo passenger) {
		return bookingService.bookAcTicket(passenger);
	}
	
	@PostMapping("slticket")
	public TrainTicket bookSlTicket(@RequestBody PassengerInfo passenger) {
		return bookingService.bookSlTicket(passenger);
	}
	
	
	@GetMapping("/getmytickets")
	public List<TrainTicket> getMyTickets(@RequestParam String userEmail){
		return bookingService.getMyTickets(userEmail);
	}
	
	@GetMapping("/test")
	public Integer test() {
		return 7;
	}
}
