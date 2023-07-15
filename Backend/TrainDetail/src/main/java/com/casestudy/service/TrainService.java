package com.casestudy.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.casestudy.model.Train;
import com.casestudy.model.TrainDetail;
import com.casestudy.model.TrainJourney;
import com.casestudy.model.TrainStation;

public interface TrainService {
	TrainDetail addTrain(TrainDetail train);
	TrainJourney addTrainJourney(int trainId,Date date);
	TrainJourney getTrain(int trainNo);
	TrainJourney updateTrainJourney(int detailId,TrainJourney trainInfo);
	void updateAcSeat(int trainNo,String status);
	void updateSlSeat(int trainNo,String status);
	List<Train> searchTrain(String from,String to,Date date);
	
	TrainStation addStation(TrainStation station);
	TrainStation updateStation(TrainStation station);
	List<TrainStation> getStationInfo(Integer trainId);
	List<String> getAllStations();
	void cancelAcTicket(int trainNo);
	void cancelSlTicket(int trainNo);
}
