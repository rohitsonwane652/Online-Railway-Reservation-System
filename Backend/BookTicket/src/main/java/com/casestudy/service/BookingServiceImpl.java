package com.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.client.TrainDetailProxy;
import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;
import com.casestudy.repository.TicketRepository;
import com.casestudy.util.TrainInfoDto;

@Service
public class BookingServiceImpl {
	
	@Autowired
	private TrainDetailProxy trainProxy;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	public TrainTicket bookTicket(PassengerInfo passenger) {
		
		int trainNo = passenger.getTrainNo();
		
		TrainInfoDto trainInfo = trainProxy.getTrain(trainNo);
		
		int acCapacity = trainInfo.getCapacityAC();
		int acSeats = trainInfo.getSeatsAC();
		
		int seatNo = acCapacity - acSeats + 1;
		String coach = "";
		if(seatNo>0 && seatNo<=10) {
			coach = "B1";
		}
		else if(seatNo>10 && seatNo<=20) {
			coach = "B2";
		}
		if(acSeats > 0) {
			trainProxy.updateAcSeat(trainNo, "AC");
		}
		
		TrainTicket ticket = new TrainTicket(1,passenger.getName(),passenger.getGender(),passenger.getAge(),seatNo,coach,
						passenger.getTrainNo(),passenger.getUsername(),passenger.getSource(),passenger.getDestination(),passenger.getTravelDate(),
						trainInfo.getTrainName());
		
		
		return ticketRepo.save(ticket);
	}
}
