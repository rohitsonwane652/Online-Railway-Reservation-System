package com.casestudy.util;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TrainInfoDto {
	
	private Integer trainNo;
	private String trainName;
	private String trainStart;
	private String trainEnd;
	
	private Date trainDate;
	private int totalSeats;
	private int capacityAC;
	private int capacitySL;
	private int seatsAC;
	private int seatsSL;
	private int fareSL;
	private int fareAC;
	private int waitingSL;
	private int waitingAC;
	
	List<String> stations;
	
	public TrainInfoDto(Integer trainNo, String trainName, String trainStart, String trainEnd, Date trainDate,
			int totalSeats, int capacityAC, int capacitySL, int seatsAC, int seatsSL, int fareSL, int fareAC,
			int waitingSL, int waitingAC, List<String> stations) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.trainStart = trainStart;
		this.trainEnd = trainEnd;
		this.trainDate = trainDate;
		this.totalSeats = totalSeats;
		this.capacityAC = capacityAC;
		this.capacitySL = capacitySL;
		this.seatsAC = seatsAC;
		this.seatsSL = seatsSL;
		this.fareSL = fareSL;
		this.fareAC = fareAC;
		this.waitingSL = waitingSL;
		this.waitingAC = waitingAC;
		this.stations = stations;
	}



	public TrainInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
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

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getSeatsAC() {
		return seatsAC;
	}

	public void setSeatsAC(int seatsAC) {
		this.seatsAC = seatsAC;
	}

	public int getSeatsSL() {
		return seatsSL;
	}

	public void setSeatsSL(int seatsSL) {
		this.seatsSL = seatsSL;
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

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
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
	
	
}
