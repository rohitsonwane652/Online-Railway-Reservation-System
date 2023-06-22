package com.casestudy.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.casestudy.model.Train;
import com.casestudy.model.TrainInfo;
import com.casestudy.model.TrainStation;

public interface TrainService {
	TrainInfo addTrain(TrainInfo trainInfo);
	TrainInfo getTrain(int trainNo);
	TrainInfo updateTrain(int detailId,TrainInfo trainInfo);
	void updateAcSeat(int trainNo,String status);
	void updateSlSeat(int trainNo,String status);
	List<Train> searchTrain(String from,String to,Date date);
	
	TrainStation addStation(TrainStation station);
}
