package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class TrainTicket {
	
	@Id
	private int pnrNo;
	private String name;
	private String gender;
	private int age;
	private int seatNo;
	private String coach;
	private int trainNo;
	private String username;
	private String source;
	private String destination;
	private String travelDate;
	private String trainName;
	
	
	
	

	public TrainTicket(int pnrNo, String name, String gender, int age, int seatNo, String coach, int trainNo,
			String username, String source, String destination, String travelDate, String trainName) {
		super();
		this.pnrNo = pnrNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNo = seatNo;
		this.coach = coach;
		this.trainNo = trainNo;
		this.username = username;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.trainName = trainName;
	}

	public TrainTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	
	
}
