package com.casestudy.model;

import java.util.List;

public class Train {
	
	private Integer trainNo;
	private Integer trainId;
	private String trainName;
	private String trainStart;
	private String trainEnd;
	private int availableAC;
	private int availableSL;
	private int fareSL;
	private int fareAC;
	private int waitingSL;
	private int waitingAC;
	List<String> stations;
	
	private String departureTime;
	private String arrivalTime;
	
	
	




	public Train(Integer trainNo, Integer trainId, String trainName, String trainStart, String trainEnd,
			int availableAC, int availableSL, int fareSL, int fareAC, int waitingSL, int waitingAC,
			List<String> stations, String departureTime, String arrivalTime) {
		super();
		this.trainNo = trainNo;
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainStart = trainStart;
		this.trainEnd = trainEnd;
		this.availableAC = availableAC;
		this.availableSL = availableSL;
		this.fareSL = fareSL;
		this.fareAC = fareAC;
		this.waitingSL = waitingSL;
		this.waitingAC = waitingAC;
		this.stations = stations;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}




	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}
	
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
	public int getAvailableAC() {
		return availableAC;
	}
	public void setAvailableAC(int availableAC) {
		this.availableAC = availableAC;
	}
	public int getAvailableSL() {
		return availableSL;
	}
	public void setAvailableSL(int availableSL) {
		this.availableSL = availableSL;
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
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getWaitingSL() {
		return waitingSL;
	}

	public void setWaitingSL(int waitingSL) {
		this.waitingSL = waitingSL;
	}
	public int getWaitingAC() {
		return waitingAC;
	}
	public void setWaitingAC(int waitingAC) {
		this.waitingAC = waitingAC;
	}
	
	
	
	
}
