package com.casestudy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.exception.TrainJourneyExistException;
import com.casestudy.exception.TrainNotFoundException;
import com.casestudy.model.Train;
import com.casestudy.model.TrainDetail;
import com.casestudy.model.TrainJourney;
import com.casestudy.model.TrainStation;
import com.casestudy.repository.TrainJourneyRepository;
import com.casestudy.repository.TrainRepository;
import com.casestudy.repository.TrainStationRepository;
import com.casestudy.util.SequenceGeneratorService;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainJourneyRepository trainJourneyRepo;
	
	@Autowired
	private TrainStationRepository stationRepo;
	
	@Autowired
	private TrainRepository trainDetailRepo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public TrainDetail addTrain(TrainDetail train) {
		Optional<TrainDetail> findedTrain = trainDetailRepo.findById(train.getTrainId());
		if(findedTrain.isPresent()) {
			throw new TrainNotFoundException("Train Already Exist " , "Train Id " , train.getTrainId() );
		}
		List<String> stations = new ArrayList<>();
		
		stations.add(train.getTrainStart());
		stations.addAll(train.getStations());
		stations.add(train.getTrainEnd());
		
		for(int i=0;i<stations.size();i++) {
			for(int j=i+1;j<stations.size();j++) {
				stationAdd(train, stations, i, j);
			}
		}
		return trainDetailRepo.save(train);
	}
	
	public void stationAdd(TrainDetail train,List<String> stations,int source, int dest) {
		TrainStation station = new TrainStation();
		station.setStationId(sequenceGeneratorService.generateSequence(TrainStation.SEQUENCE_NAME));
		station.setTrainId(train.getTrainId());
		station.setTrainFrom(stations.get(source));
		station.setTrainTo(stations.get(dest));
		stationRepo.save(station);
	}


	@Override
	public TrainJourney addTrainJourney(final int trainId,final Date date) {
		TrainDetail trainDetail = trainDetailRepo.findById(trainId).orElse(null);
		List<TrainJourney> trainJournies = trainJourneyRepo.findByTrainDate(date);
		for(TrainJourney existJourney:trainJournies) {
			if(existJourney.getTrainId() == trainId) {
				throw new TrainJourneyExistException("Train Journey Already Exist for given Date with given Train Details");
			}
		}
		TrainJourney trainJourney = new TrainJourney();
		trainJourney.setTrainNo(sequenceGeneratorService.generateSequence(TrainJourney.SEQUENCE_NAME));
		trainJourney.setTrainId(trainId);
		trainJourney.setTrainDetail(trainDetail);
		trainJourney.setSeatsAC(trainDetail.getCapacityAC());
		trainJourney.setSeatsSL(trainDetail.getCapacitySL());
		trainJourney.setTrainDate(date);
		trainJourney.setWaitingAC(0);
		trainJourney.setWaitingSL(0);
		return trainJourneyRepo.save(trainJourney);
	}
	
	
	@Override
	public TrainJourney getTrain(final int trainNo) {
		return trainJourneyRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
	}
	
	
	@Override
	public TrainJourney updateTrainJourney(final int trainNo,final TrainJourney trainInfo) {
		final TrainJourney existingTrain = trainJourneyRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
//		existingTrain.setTrainName(trainInfo.getTrainName());
//		existingTrain.setTrainStart(trainInfo.getTrainStart());
//		existingTrain.setTrainEnd(trainInfo.getTrainEnd());
//		existingTrain.setTrainDate(trainInfo.getTrainDate());
//		existingTrain.setTotalSeats(trainInfo.getTotalSeats());
//		existingTrain.setCapacityAC(trainInfo.getCapacityAC());
//		existingTrain.setCapacitySL(trainInfo.getCapacitySL());
//		existingTrain.setSeatsAC(trainInfo.getSeatsAC());
//		existingTrain.setSeatsSL(trainInfo.getSeatsSL());
//		existingTrain.setFareAC(trainInfo.getFareAC());
//		existingTrain.setFareSL(trainInfo.getFareSL());
//		existingTrain.setWaitingAC(trainInfo.getWaitingAC());
//		existingTrain.setWaitingSL(trainInfo.getWaitingSL());
		return trainJourneyRepo.save(existingTrain);
	}



	@SuppressWarnings("deprecation")
	@Override
	public List<Train> searchTrain(String from, String to, Date date) {
		List<TrainStation> stationList = stationRepo.findByTrainFromAndTrainTo(from, to);
		
		List<Train> searchedTrains = new ArrayList<>();
		
		for(TrainStation station : stationList) {
			int trainId = station.getTrainId();
			
			TrainJourney trainInfo = trainJourneyRepo.findByTrainId(trainId);
			TrainDetail trainDetail = trainInfo.getTrainDetail();
			
			Date trainDate = trainInfo.getTrainDate();
			trainDate.setHours(0);
			trainDate.setMinutes(0);
			date.setHours(0);
			date.setMinutes(0);
			if(trainDate.equals(date)) {
				Train train = new Train();
				
				int stationFare = station.getJourneyFare();
				int journeyFareAC = stationFare + trainDetail.getFareAC();
				int journeyFareSL = stationFare + trainDetail.getFareSL();
				
				train.setTrainNo(trainInfo.getTrainNo());
				train.setTrainId(trainId);
				train.setTrainName(trainDetail.getTrainName());
				train.setTrainStart(trainDetail.getTrainStart());
				train.setTrainEnd(trainDetail.getTrainEnd());
				train.setAvailableAC(trainInfo.getSeatsAC());
				train.setAvailableSL(trainInfo.getSeatsSL());
				train.setFareAC(journeyFareAC);
				train.setFareSL(journeyFareSL);
				train.setStations(trainDetail.getStations());
				train.setDepartureTime(station.getDepartureTime());
				train.setArrivalTime(station.getArrivalTime());
				train.setWaitingAC(trainInfo.getWaitingAC());
				train.setWaitingSL(trainInfo.getWaitingSL());
				train.setDepartureTime(station.getDepartureTime());
				train.setArrivalTime(station.getArrivalTime());
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
		TrainJourney info = trainJourneyRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
		int acSeats = info.getSeatsAC();
		if(status.equalsIgnoreCase("AC")) {
			acSeats = acSeats - 1;
			info.setSeatsAC(acSeats);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("WL")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC + 1;
			info.setWaitingAC(newWaitingAC);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancel")) {
			acSeats = acSeats + 1;
			info.setSeatsAC(acSeats);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancelwl")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC - 1;
			info.setWaitingAC(newWaitingAC);
			trainJourneyRepo.save(info);
		}
	}


	@Override
	public void updateSlSeat(int trainNo,String status) {
		
		TrainJourney info = trainJourneyRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
		int slSeats = info.getSeatsSL();
		if(status.equalsIgnoreCase("SL")) {
			slSeats = slSeats - 1;
			info.setSeatsAC(slSeats);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("WL")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC + 1;
			info.setWaitingAC(newWaitingAC);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancel")) {
			slSeats = slSeats + 1;
			info.setSeatsAC(slSeats);
			trainJourneyRepo.save(info);
		}
		else if(status.equalsIgnoreCase("cancelwl")) {
			int waitingAC = info.getWaitingAC();
			int newWaitingAC = waitingAC - 1;
			info.setWaitingAC(newWaitingAC);
			trainJourneyRepo.save(info);
		}
		
	}

	@Override
	public List<String> getAllStations() {
		List<TrainStation> stations = stationRepo.findAll();

		HashSet<String> setOfStation = new HashSet<>();
		for(TrainStation station:stations) {
			setOfStation.add(station.getTrainFrom());
			setOfStation.add(station.getTrainTo());
		}
//		stations.stream().forEach(station -> setOfStation.add(station.getTrainFrom()));
		
		List<String> listOfStations = new ArrayList<>(setOfStation);
		
		return listOfStations;
	}






}
