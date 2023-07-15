package com.casestudy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.EmailRequest;
import com.casestudy.model.PassengerInfo;
import com.casestudy.model.TrainTicket;
import com.casestudy.service.BookingService;

/**
 * Controller to handle crud operations
 * @author Rohit
 *
 */
@RestController
@RequestMapping("/book")
public class BookingController {
	

	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * BookingService Autowired
	 */
	@Autowired
	private BookingService bookingService;
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Logger for BookingController
	 */
	/*default*/
	Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is to Book Ac Tickets
	 */
	/*default*/
	@PostMapping("/acticket")
	public TrainTicket bookAcTicket(@RequestBody final PassengerInfo passenger) {
		logger.info("[bookAcTicket] Method called");
		logger.debug("[bookAcTicket] Method called");
		return bookingService.bookAcTicket(passenger);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is to Book Sleeper Ticket
	 */
	/*default*/
	@PostMapping("slticket")
	public TrainTicket bookSlTicket(@RequestBody final PassengerInfo passenger) {
		logger.info("[bookSlTicket] Method called");
		logger.debug("[bookSlTicket] Method called");
		return bookingService.bookSlTicket(passenger);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is for Cancelling the ticket
	 */
	/*default*/
	@PutMapping("/cancelacticket/{pnrNo}")
	public void cancelAcTicket(@PathVariable final int pnrNo) {
		logger.info("[cancelAcTicket] Method called");
		logger.debug("[cancelAcTicket] Method called");
		bookingService.cancelAcTicket(pnrNo);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is for Cancelling the ticket
	 */
	/*default*/
	@PutMapping("/cancelslticket/{pnrNo}")
	public void cancelSlTicket(@PathVariable final int pnrNo) {
		logger.info("[cancelSlTicket] Method called");
		logger.debug("[cancelSlTicket] Method called");
		bookingService.cancelSlTicket(pnrNo);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is for Get All tickets with userEmail
	 */
	/*default*/
	@GetMapping("/getmytickets")
	public List<TrainTicket> getMyTickets(@RequestParam final String userEmail){
		logger.info("[getMyTickets] Method called");
		logger.debug("[getMyTickets] Method called");
		return bookingService.getMyTickets(userEmail);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Description : This method is to check PnrStatus of ticket
	 */
	/*default*/
	@GetMapping("/pnrstatus/{pnrNo}")
	public TrainTicket getMyPnrStatus(@PathVariable final int pnrNo) {
		logger.info("[getMyPnrStatus] Method called");
		logger.debug("[getMyPnrStatus] Method called");
		return bookingService.getPnrStatus(pnrNo);
	}
	
	/**
	 * @author Rohit
	 * Modified By : Rohit
	 * Logger for BookingController
	 */
	/*default*/
	@PostMapping("/send-email")
	public void sendEmail(@RequestBody final EmailRequest emailRequest) {
		final String to = emailRequest.getTo();
		final String subject = emailRequest.getSubject();
		final String message = emailRequest.getMessage();
		
		bookingService.sendEmail(to, subject, message);
	}
}
