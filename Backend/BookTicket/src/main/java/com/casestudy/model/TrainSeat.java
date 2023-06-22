package com.casestudy.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TrainSeat {
	
	@Id
	private int trainNo;
	private List<Integer> cancelAcSeats;
	private List<Integer> cancelSlSeats;
	
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public List<Integer> getCancelAcSeats() {
		return cancelAcSeats;
	}
	public void setCancelAcSeats(List<Integer> cancelAcSeats) {
		this.cancelAcSeats = cancelAcSeats;
	}
	public List<Integer> getCancelSlSeats() {
		return cancelSlSeats;
	}
	public void setCancelSlSeats(List<Integer> cancelSlSeats) {
		this.cancelSlSeats = cancelSlSeats;
	}
	public TrainSeat(int trainNo,List<Integer> cancelAcSeats,List<Integer> cancelSlSeats) {
		super();
		this.trainNo = trainNo;
		this.cancelAcSeats = cancelAcSeats;
		this.cancelSlSeats = cancelSlSeats;
	}
	public TrainSeat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
