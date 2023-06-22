package com.casestudy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.exception.TrainNotFoundException;
import com.casestudy.model.Train;
import com.casestudy.model.TrainInfo;
import com.casestudy.model.TrainStation;
import com.casestudy.repository.TrainRepository;
import com.casestudy.repository.TrainStationRepository;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainRepository trainRepo;
	
	@Autowired
	private TrainStationRepository stationRepo;

	@Override
	public TrainInfo addTrain(final TrainInfo trainInfo) {
		return trainRepo.save(trainInfo);
	}
	
	
	@Override
	public TrainInfo getTrain(final int trainNo) {
		return trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
	}
	
	
	@Override
	public TrainInfo updateTrain(final int trainNo,final TrainInfo trainInfo) {
		final TrainInfo existingTrain = trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
		existingTrain.setTrainName(trainInfo.getTrainName());
		existingTrain.setTrainStart(trainInfo.getTrainStart());
		existingTrain.setTrainEnd(trainInfo.getTrainEnd());
		existingTrain.setTrainDate(trainInfo.getTrainDate());
		existingTrain.setTotalSeats(trainInfo.getTotalSeats());
		existingTrain.setCapacityAC(trainInfo.getCapacityAC());
		existingTrain.setCapacitySL(trainInfo.getCapacitySL());
		existingTrain.setSeatsAC(trainInfo.getSeatsAC());
		existingTrain.setSeatsSL(trainInfo.getSeatsSL());
		existingTrain.setFareAC(trainInfo.getFareAC());
		existingTrain.setFareSL(trainInfo.getFareSL());
		existingTrain.setWaitingAC(trainInfo.getWaitingAC());
		existingTrain.setWaitingSL(trainInfo.getWaitingSL());
		return trainRepo.save(existingTrain);
	}



	@SuppressWarnings("deprecation")
	@Override
	public List<Train> searchTrain(String from, String to, Date date) {
		List<TrainStation> stationList = stationRepo.findByTrainFromAndTrainTo(from, to);
		
		List<Train> searchedTrains = new ArrayList<>();
		
		for(TrainStation station : stationList) {
			int trainNo = station.getTrainNo();
			
			TrainInfo trainInfo = trainRepo.findByTrainNo(trainNo);
			
			Date trainDate = trainInfo.getTrainDate();
			trainDate.setHours(0);
			trainDate.setMinutes(0);
			
			if(trainDate.equals(date)) {
				
				Train train = new Train();
				
				int stationFare = station.getJourneyFare();
				int journeyFareAC = stationFare + trainInfo.getFareAC();
				int journeyFareSL = stationFare + trainInfo.getFareSL();
				
				train.setTrainNo(trainNo);
				train.setTrainName(trainInfo.getTrainName());
				train.setTrainStart(trainInfo.getTrainStart());
				train.setTrainEnd(trainInfo.getTrainEnd());
				train.setAvailableAC(trainInfo.getSeatsAC());
				train.setAvailableSL(trainInfo.getSeatsSL());
				train.setFareAC(journeyFareAC);
				train.setFareSL(journeyFareSL);
				train.setStations(trainInfo.getStations());
				train.setDepartureTime(station.getDepartureTime());
				train.setArrivalTime(station.getArrivalTime());
				train.setWaitingAC(trainInfo.getWaitingAC());
				train.setWaitingSL(trainInfo.getWaitingSL());
				
				searchedTrains.add(train);
			}
		}
		
		return searchedTrains;
	}


	
	
	
	@Override
	public TrainStation addStation(TrainStation station) {
		return stationRepo.save(station);
	}


	@Override
	public void updateAcSeat(int trainNo,String status) {
		TrainInfo info = trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
		int acSeats = info.getSeatsAC();
		if(status.equalsIgnoreCase("AC")) {
			acSeats = acSeats - 1;
			info.setSeatsAC(acSeats);
			trainRepo.save(info);
		}
		else if(status.equalsIgnoreCase("WL")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC + 1;
			info.setWaitingAC(newWaitingAC);
			trainRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancel")) {
			acSeats = acSeats + 1;
			info.setSeatsAC(acSeats);
			trainRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancelwl")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC - 1;
			info.setWaitingAC(newWaitingAC);
			trainRepo.save(info);
		}
	}


	@Override
	public void updateSlSeat(int trainNo,String status) {
//		TrainInfo info = trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
//		int slSeats = info.getSeatsSL();
//		if(slSeats == 0) {
//			int waitingSL = info.getWaitingSL();
//			info.setWaitingSL(waitingSL+1);
//			trainRepo.save(info);
//		}
//		else {
//			slSeats = slSeats - 1;
//			info.setSeatsSL(slSeats);
//			trainRepo.save(info);
//		}
		
	}




}
