package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.casestudy.client.TrainDetailProxy;
import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;
import com.casestudy.repository.TicketRepository;
import com.casestudy.service.BookingServiceImpl;
import com.casestudy.util.DatabaseSequence;
import com.casestudy.util.SequenceGeneratorService;
import com.casestudy.util.TrainDetail;
import com.casestudy.util.TrainInfoDto;


@SpringBootTest
class BookTicketApplicationTests {

	@Mock
	private TicketRepository ticketRepo;
	
	@MockBean
	private TrainDetailProxy trainProxy;

	
	@InjectMocks
	private BookingServiceImpl bookingService;
	
	@Mock
	 private SequenceGeneratorService sequenceGeneratorService;

	 @Mock
	 private MongoOperations mongoOperations;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	void testBookAcTicket() {
		PassengerInfo passenger = new PassengerInfo("Rohit Sonwane","Male",22,101,"rohit@gmail.com","Mumbai","Nagpur","8:00AM","7:00PM");
		
		int trainNo = 101;
		TrainDetail train = new TrainDetail();
		train.setCapacityAC(70);
		
		TrainInfoDto trainInfo = new TrainInfoDto(101,1129,train,new Date("01/08/2023"),70,70,0,0);
		
		when(trainProxy.getTrain(trainNo)).thenReturn(trainInfo);
		when(sequenceGeneratorService.generateSequence(TrainTicket.SEQUENCE_NAME)).thenReturn(1);
		
		
		bookingService.bookAcTicket(passenger);
		TrainTicket newTicket = new TrainTicket(1,"Rohit Sonwane","Male",22,1,"B1","AC",101,"rohit@gmail.com","Mumbai","Nagpur",
				"08 January 2023",null,"8:00AM","7:00PM");

		verify(ticketRepo, times(1)).save(newTicket);
	}
	
	@Test
	void testBookSlTicket() {
		PassengerInfo passenger = new PassengerInfo("Rohit Sonwane","Male",22,101,"rohit@gmail.com","Mumbai","Nagpur","8:00AM","7:00PM");
		
		int trainNo = 101;
		TrainDetail train = new TrainDetail();
		train.setCapacitySL(70);
		
		TrainInfoDto trainInfo = new TrainInfoDto(101,1129,train,new Date("01/08/2023"),70,70,0,0);
		
		when(trainProxy.getTrain(trainNo)).thenReturn(trainInfo);
		when(sequenceGeneratorService.generateSequence(TrainTicket.SEQUENCE_NAME)).thenReturn(1);
		
		
		bookingService.bookSlTicket(passenger);
		TrainTicket newTicket = new TrainTicket(1,"Rohit Sonwane","Male",22,1,"S1","Sleeper",101,"rohit@gmail.com","Mumbai","Nagpur",
				"08 January 2023",null,"8:00AM","7:00PM");

		verify(ticketRepo, times(1)).save(newTicket);
	}
	
	@Test
	void testGetMyTickets() {
		List<TrainTicket> tickets = new ArrayList();
		when(ticketRepo.findByUsername("rohit@gmail.com")).thenReturn(tickets);
		
		List<TrainTicket> findedTickets = bookingService.getMyTickets("rohit@gmail.com");
		assertEquals(0, findedTickets.size());
	}
	
	@Test 
	void testCancelAcTicket() {
		int pnrNo = 100101;
		TrainTicket ticket = new TrainTicket();
		ticket.setPnrNo(pnrNo);
		when(ticketRepo.findById(pnrNo)).thenReturn(Optional.of(ticket));
		bookingService.cancelAcTicket(pnrNo);
	}
	
	@Test 
	void testCancelSLTicket() {
		int pnrNo = 100101;
		TrainTicket ticket = new TrainTicket();
		ticket.setPnrNo(pnrNo);
		when(ticketRepo.findById(pnrNo)).thenReturn(Optional.of(ticket));
		bookingService.cancelSlTicket(pnrNo);
	}
	
	@Test
	void testGetPnrStatus() {
		int pnrNo = 100101;
		TrainTicket ticket = new TrainTicket();
		ticket.setPnrNo(pnrNo);
		when(ticketRepo.findById(pnrNo)).thenReturn(Optional.of(ticket));
		bookingService.getPnrStatus(pnrNo);
	}

}
