package com.casestudy.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;

public interface BookingService {
	TrainTicket bookAcTicket(PassengerInfo passenger);
	TrainTicket bookSlTicket(PassengerInfo passenger);
	List<TrainTicket> getMyTickets(@RequestParam String userEmail);
	TrainTicket getPnrStatus(int pnrNo);
	void sendEmail(String to, String subject, String message);
	void cancelAcTicket(int pnrNo);
	void cancelSlTicket(int pnrNo);
}
