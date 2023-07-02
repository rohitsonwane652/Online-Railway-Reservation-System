package com.casestudy.model;

import org.springframework.stereotype.Component;

@Component
public class PassengerInfo {
	
	private String name;
	private String gender;
	private int age;
	private int trainNo;
	private String userEmail;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	
	public PassengerInfo(String name, String gender, int age, int trainNo, String userEmail, String source,
			String destination, String departureTime, String arrivalTime) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.trainNo = trainNo;
		this.userEmail = userEmail;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public PassengerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
