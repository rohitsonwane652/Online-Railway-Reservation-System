package com.casestudy.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("trains")
public class TrainDetail {
	@Id
	private Integer trainId;
	private String trainName;
	private String trainStart;
	private String trainEnd;
	
	private int capacityAC;
	private int capacitySL;
	private int fareSL;
	private int fareAC;
	
	List<String> stations;

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainStart() {
		return trainStart;
	}

	public void setTrainStart(String trainStart) {
		this.trainStart = trainStart;
	}

	public String getTrainEnd() {
		return trainEnd;
	}

	public void setTrainEnd(String trainEnd) {
		this.trainEnd = trainEnd;
	}


	public int getCapacityAC() {
		return capacityAC;
	}

	public void setCapacityAC(int capacityAC) {
		this.capacityAC = capacityAC;
	}

	public int getCapacitySL() {
		return capacitySL;
	}

	public void setCapacitySL(int capacitySL) {
		this.capacitySL = capacitySL;
	}

	public int getFareSL() {
		return fareSL;
	}

	public void setFareSL(int fareSL) {
		this.fareSL = fareSL;
	}

	public int getFareAC() {
		return fareAC;
	}

	public void setFareAC(int fareAC) {
		this.fareAC = fareAC;
	}

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}

	public TrainDetail(Integer trainId, String trainName, String trainStart, String trainEnd,
			int capacityAC, int capacitySL, int fareSL, int fareAC, List<String> stations) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainStart = trainStart;
		this.trainEnd = trainEnd;
		this.capacityAC = capacityAC;
		this.capacitySL = capacitySL;
		this.fareSL = fareSL;
		this.fareAC = fareAC;
		this.stations = stations;
	}

	public TrainDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TrainDetail [trainId=" + trainId + ", trainName=" + trainName + ", trainStart=" + trainStart
				+ ", trainEnd=" + trainEnd + ", capacityAC=" + capacityAC
				+ ", capacitySL=" + capacitySL + ", fareSL=" + fareSL + ", fareAC=" + fareAC + ", stations=" + stations
				+ "]";
	}
	
	
	
}
