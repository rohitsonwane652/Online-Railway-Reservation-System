package com.casestudy.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.client.TrainDetailProxy;
import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;
import com.casestudy.repository.TicketRepository;
import com.casestudy.util.SequenceGeneratorService;
import com.casestudy.util.TrainDetail;
import com.casestudy.util.TrainInfoDto;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private TrainDetailProxy trainProxy;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public TrainTicket bookAcTicket(PassengerInfo passenger) {
		
		int trainNo = passenger.getTrainNo();
		int pnrNo = sequenceGeneratorService.generateSequence(TrainTicket.SEQUENCE_NAME);
		TrainInfoDto trainInfo = trainProxy.getTrain(trainNo);
		TrainDetail train = trainInfo.getTrainDetail();
		int acCapacity = train.getCapacityAC();
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
		
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
        String travelDate = dateFormat.format(trainInfo.getTrainDate());  
		
		TrainTicket ticket = new TrainTicket(pnrNo,passenger.getName(),passenger.getGender(),passenger.getAge(),seatNo,coach,"AC",
						passenger.getTrainNo(),passenger.getUserEmail(),passenger.getSource(),passenger.getDestination(),travelDate,
						train.getTrainName(),passenger.getDepartureTime(),passenger.getArrivalTime());
		
		
		return ticketRepo.save(ticket);
	}
	
	@Override
	public TrainTicket bookSlTicket(PassengerInfo passenger) {
		
		int trainNo = passenger.getTrainNo();
		int pnrNo = sequenceGeneratorService.generateSequence(TrainTicket.SEQUENCE_NAME);
		TrainInfoDto trainInfo = trainProxy.getTrain(trainNo);
		TrainDetail train = trainInfo.getTrainDetail();
		int slCapacity = train.getCapacitySL();
		int slSeats = trainInfo.getSeatsSL();
		
		int seatNo = slCapacity - slSeats + 1;
		String coach = "";
		
		if(seatNo>0 && seatNo<=10) {
			coach = "S1";
		}
		else if(seatNo>10 && seatNo<=20) {
			coach = "S2";
		}
		if(slSeats > 0) {
			trainProxy.updateAcSeat(trainNo, "SL");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
        String travelDate = dateFormat.format(trainInfo.getTrainDate());  
		
		TrainTicket ticket = new TrainTicket(pnrNo,passenger.getName(),passenger.getGender(),passenger.getAge(),seatNo,coach,"Sleeper",
						passenger.getTrainNo(),passenger.getUserEmail(),passenger.getSource(),passenger.getDestination(),travelDate,
						train.getTrainName(),passenger.getDepartureTime(),passenger.getArrivalTime());
		
		
		return ticketRepo.save(ticket);
	}

	@Override
	public List<TrainTicket> getMyTickets(String userEmail) {
		// TODO Auto-generated method stub
		return ticketRepo.findByUsername(userEmail);
	}

	
}
