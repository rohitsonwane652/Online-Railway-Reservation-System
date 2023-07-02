package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "stations")
public class TrainStation {
	
	@Transient
    public static final String SEQUENCE_NAME = "station_sequence";
	
	@Id
	private int stationId;
	private String trainFrom;
	private String trainTo;
//	private String trainFare;
	private String departureTime;
	private String arrivalTime;
	private int journeyFare;
	
	private Integer trainId;
	
	

	public TrainStation(int stationId, String trainFrom, String trainTo, String departureTime,
			String arrivalTime,Integer journeyFare, Integer trainNo) {
		super();
		this.stationId = stationId;
		this.trainFrom = trainFrom;
		this.trainTo = trainTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.journeyFare = journeyFare;
		this.trainId = trainNo;
	}
	
	



	public TrainStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getStationId() {
		return stationId;
	}



	

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}





	public String getTrainFrom() {
		return trainFrom;
	}





	public void setTrainFrom(String trainFrom) {
		this.trainFrom = trainFrom;
	}





	public String getTrainTo() {
		return trainTo;
	}





	public void setTrainTo(String trainTo) {
		this.trainTo = trainTo;
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




	public int getJourneyFare() {
		return journeyFare;
	}





	public void setJourneyFare(int journeyFare) {
		this.journeyFare = journeyFare;
	}





	public Integer getTrainId() {
		return trainId;
	}





	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}





	@Override
	public String toString() {
		return "TrainStation [stationId=" + stationId + ", trainFrom=" + trainFrom + ", trainTo=" + trainTo
				+ ", trainFare=" + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", trainNo=" + trainId + "]";
	}
	
	
}
