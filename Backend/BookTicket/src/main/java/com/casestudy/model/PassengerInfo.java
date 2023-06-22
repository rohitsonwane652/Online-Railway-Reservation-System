package com.casestudy.model;

import org.springframework.stereotype.Component;

@Component
public class PassengerInfo {
	
	private String name;
	private String gender;
	private int age;
	private int trainNo;
	private String username;
	private String source;
	private String destination;
	private String travelDate;
	
	
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
	
	
	public PassengerInfo(String name, String gender, int age, int trainNo, String username, String source,
			String destination, String travelDate) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.trainNo = trainNo;
		this.username = username;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
	}
	public PassengerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
