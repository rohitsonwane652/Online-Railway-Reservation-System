package com.casestudy.controller;


import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Train;
import com.casestudy.model.TrainDetail;
import com.casestudy.model.TrainJourney;
import com.casestudy.model.TrainStation;
import com.casestudy.service.TrainService;

/**
 * Controller to handle crud operations
 * @author Rohit
 *
 */
@RestController	
@RequestMapping("/train")
public class TrainController {
	
	/**
	 * Logger for TrainController
	 */
	/*default*/
	Logger logger = LoggerFactory.getLogger(TrainController.class);
	
	
	/**
	 * TrainService Autowired
	 */
	@Autowired
	private TrainService trainService;
	
	@PostMapping("/addtrain")
	public ResponseEntity<TrainDetail> addTrain(@RequestBody final TrainDetail train){
		final TrainDetail trainDetail = trainService.addTrain(train);
		return new ResponseEntity<>(trainDetail,HttpStatus.OK);
	}
	
	
	/**
	*Add New Train Details
	*/ 	
	@PostMapping("/addtrainjourney")
	public ResponseEntity<TrainJourney> addTrainJourney(@RequestParam Integer trainId,@RequestParam final @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			){
		
			final TrainJourney journey = trainService.addTrainJourney(trainId, date);
			return new ResponseEntity<>(journey,HttpStatus.OK);

	}
	
	
	/**
	 *Get Train by TrainNumber
	 */
	@GetMapping("/find")
	public ResponseEntity<TrainJourney> getTrain(@RequestParam final int trainNo){
		final TrainJourney info = trainService.getTrain(trainNo);
		
		logger.info("[getTrain] method called");
		logger.debug("[getTrain] method called");
		return new ResponseEntity<>(info,HttpStatus.OK);
	}
	

	/**
	 * Update Existing Train Details
	 */
	@PutMapping("/updatetrainjourney")
	public ResponseEntity<TrainJourney> updateTrainJourney(@RequestParam final int trainNo,@RequestBody final TrainJourney trainInfo){
		final TrainJourney info = trainService.updateTrainJourney(trainNo, trainInfo);
		
		logger.info("[updateTrain] Method called");
		logger.debug("[updateTrain] Method called");
		
		return new ResponseEntity<>(info,HttpStatus.OK);
	}
	
	/**
	 * Update Train AC Seats
	 */
	@PutMapping("/updateAcSeat/{trainNo}/{status}")
	public void updateAcSeat(@PathVariable final int trainNo,@PathVariable final String status) {
		trainService.updateAcSeat(trainNo, status);
	}
	
	/**
	 * Update Train SL Seats
	 */
	@PutMapping("/updateSlSeat/{trainNo}/{status}")
	public void updateSlSeat(@PathVariable final int trainNo,@PathVariable final String status) {
		trainService.updateSlSeat(trainNo, status);
	}
	
	@PutMapping("/cancelacseat/{trainNo}")
	public void cancelAcSeat(@PathVariable final int trainNo) {
		trainService.cancelAcTicket(trainNo);
	}
	
	@PutMapping("/cancelslseat/{trainNo}")
	public void cancelSlSeat(@PathVariable final int trainNo) {
		trainService.cancelSlTicket(trainNo);
	}
	
	/**
	 * Search Trains for Source to Destination
	 */
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search")
	public List<Train> searchTrain(@RequestParam final String source, @RequestParam final String dest,
			@RequestParam final @DateTimeFormat(pattern = "MM/dd/yyyy") Date date){
		return trainService.searchTrain(source,dest,date);
	}
	
	
	/**
	 * Add new Station Details
	 */
	@PostMapping("/addstation")
	public ResponseEntity<TrainStation> addStation(@RequestBody final TrainStation station){
		final TrainStation trainsStation = trainService.addStation(station);
		
		logger.info("New Train Stations Added");
		
		return new ResponseEntity<>(trainsStation,HttpStatus.OK);
	}
	
	@PutMapping("/updatestation")
	public ResponseEntity<TrainStation> updateStation(@RequestBody final TrainStation station){
		System.out.println("Hello");
		final TrainStation trainStation = trainService.updateStation(station);
		return new ResponseEntity<>(trainStation,HttpStatus.OK);
	}
	
	@GetMapping("/getstationinfo")
	public List<TrainStation> getStationInfo(@RequestParam final Integer trainId){
		return trainService.getStationInfo(trainId);
	}
	
	
	@GetMapping("/getallstations")
	public List<String> getAllStations(){
		return trainService.getAllStations();
	}
	
	
	
	
	/**
	 * to handle invalid token
	 * @return
	 */
	@GetMapping("/invalid")
	public ResponseEntity<String> invalidtoken() {

		return new ResponseEntity<>("Invalid Jwt Token or Expired", HttpStatus.UNAUTHORIZED);

	}
	
	/**
	 * To handle unauthorized person
	 * @return
	 */
	@GetMapping("/unauthorized")
	public ResponseEntity<String> unauthorized() {

		return new ResponseEntity<>("You are not authorized to access this url", HttpStatus.UNAUTHORIZED);

	}

	/**
	 * To handle if Token is missing
	 * @return
	 */
	@GetMapping("/missingAuth")
	public ResponseEntity<String> missingAuth() {

		return new ResponseEntity<>(
				"Missing JWT token. please provide one. if u dont have one please get one using /auth/token",
				HttpStatus.UNAUTHORIZED);
	}
	
	
	
}
