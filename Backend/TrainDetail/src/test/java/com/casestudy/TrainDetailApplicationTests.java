package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.casestudy.model.Train;
import com.casestudy.model.TrainJourney;
import com.casestudy.model.TrainStation;
import com.casestudy.repository.TrainJourneyRepository;
import com.casestudy.repository.TrainStationRepository;
import com.casestudy.service.TrainServiceImpl;

@SpringBootTest
class TrainDetailApplicationTests {

	@Mock
	private TrainJourneyRepository trainRepo;
	
	@Mock
	private TrainStationRepository trainStationRepo;
	
	@InjectMocks
	private TrainServiceImpl trainService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddTrain() {
		TrainJourney traininfo = new TrainJourney();
		
		traininfo.setTrainNo(101);
		
//		trainService.addTrainJourney(traininfo);
		
		assertEquals(101, traininfo.getTrainNo());
		
		verify(trainRepo, times(1)).save(traininfo);
	}
	
	@Test
	void testGetTrain() {
		int trainNo = 101;
		TrainJourney trainInfo = new TrainJourney();
		trainInfo.setTrainNo(trainNo);
		
		when(trainRepo.findById(trainNo)).thenReturn(Optional.of(trainInfo));
		
		TrainJourney result = trainService.getTrain(trainNo);
		
		assertEquals(trainInfo, result);
	}
	
	@Test
	void testUpdateTrain() {
		int trainNo = 101;
		String trainName = "Express";
		String trainStart = "Mumbai";
		String trainEnd = "Nagpur";
		int capacityAC = 60;
		int capacitySL = 40;
		int fareSL = 100;
		int fareAC = 150;
		
		TrainJourney existingTrain = new TrainJourney();
		existingTrain.setTrainNo(trainNo);
//		existingTrain.setTrainName(trainName);
//		
//		
//		TrainJourney updatedTrain = new TrainJourney();
//		updatedTrain.setTrainNo(trainNo);
//		updatedTrain.setTrainName(trainName);
//		updatedTrain.setTrainStart(trainStart);
//		updatedTrain.setTrainEnd(trainEnd);
//		updatedTrain.setCapacityAC(capacityAC);
//		updatedTrain.setCapacitySL(capacitySL);
//		updatedTrain.setFareAC(fareAC);
//		updatedTrain.setFareSL(fareSL);
		
		when(trainRepo.findById(trainNo)).thenReturn(Optional.of(existingTrain));
		when(trainRepo.save(existingTrain)).thenReturn(existingTrain);
		
//		trainService.updateTrainJourney(trainNo, updatedTrain);
//		
//
//		assertEquals(trainStart, existingTrain.getTrainStart());
//		assertEquals(trainEnd, existingTrain.getTrainEnd());
//		assertEquals(capacityAC, existingTrain.getCapacityAC());
//		assertEquals(capacitySL, existingTrain.getCapacitySL());
//		assertEquals(fareAC, existingTrain.getFareAC());
//		assertEquals(fareSL, existingTrain.getFareSL());
		
	}
	
	@Test
	void testSearchTrain() {
		TrainStation station = new TrainStation(1,"Mumbai","Nagpur","08:15PM","07:00AM",400,101);
		TrainStation station2 = new TrainStation(2,"Mumbai","Nagpur","08:15PM","07:00AM",300,102);
		
		List<TrainStation> stationList = new ArrayList<>();
		
		stationList.add(station);
		stationList.add(station2);
		
		when(trainStationRepo.findByTrainFromAndTrainTo("Mumbai", "Nagpur")).thenReturn(stationList);
		
		TrainJourney existingTrain = new TrainJourney();
		existingTrain.setTrainNo(101);
//		existingTrain.setTrainName("Maharashtra Express");
//		existingTrain.setTrainDate(new Date(2023-06-23));
//		
//		TrainJourney existingTrain2 = new TrainJourney();
//		existingTrain2.setTrainNo(102);
//		existingTrain2.setTrainName("Hawada Express");
//		existingTrain2.setTrainDate(new Date(2023-06-23));
//		
//		when(trainRepo.findByTrainNo(101)).thenReturn(existingTrain);
//		when(trainRepo.findByTrainNo(102)).thenReturn(existingTrain2);
		
		Date date = new Date(2023-06-23);
		date.setHours(0);
		date.setMinutes(0);
		List<Train> trains = trainService.searchTrain("Mumbai", "Nagpur", date);

		assertEquals(101, trains.get(0).getTrainNo());
		assertEquals(102, trains.get(1).getTrainNo());
		
		
		
	}
	
	@Test
	void testUpdateAcSeat() {
		int trainNo = 101;
		String trainName = "Express";
		String trainStart = "Mumbai";
		String trainEnd = "Nagpur";
		int capacityAC = 60;
		int capacitySL = 40;
		int fareSL = 100;
		int fareAC = 150;
		
		TrainJourney updatedTrain = new TrainJourney();
		updatedTrain.setTrainNo(trainNo);
//		updatedTrain.setTrainName(trainName);
//		updatedTrain.setTrainNo(trainNo);
//		updatedTrain.setTrainName(trainName);
//		updatedTrain.setTrainStart(trainStart);
//		updatedTrain.setTrainEnd(trainEnd);
//		updatedTrain.setCapacityAC(capacityAC);
//		updatedTrain.setCapacitySL(capacitySL);
//		updatedTrain.setSeatsAC(60);
//		updatedTrain.setWaitingAC(0);
//		updatedTrain.setFareAC(fareAC);
//		updatedTrain.setFareSL(fareSL);
//		
		when(trainRepo.findById(trainNo)).thenReturn(Optional.of(updatedTrain));
		
		trainService.updateAcSeat(trainNo, "AC");
		
		assertEquals(59, updatedTrain.getSeatsAC());
		
		trainService.updateAcSeat(trainNo, "WL");
		
		assertEquals(1, updatedTrain.getWaitingAC());
		
		trainService.updateAcSeat(trainNo, "cancel");
		
		assertEquals(60, updatedTrain.getSeatsAC());
		
		trainService.updateAcSeat(trainNo, "cancelwl");
		
		assertEquals(0, updatedTrain.getWaitingAC());
		
	}
	
	
	@Test
	void testAddStation() {
		TrainStation station = new TrainStation();
		
		station.setTrainFrom("Mumbai");
		station.setTrainTo("Nagpur");
		
		trainService.addStation(station);
		assertEquals("Mumbai", station.getTrainFrom());
		verify(trainStationRepo, times(1)).save(station);
	}

}
