package com.casestudy.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class TrainTicket {
	
	@Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";
	
	@Id
	private int pnrNo;
	private String name;
	private String gender;
	private int age;
	private int seatNo;
	private String coach;
	private String seatType;
	private int trainNo;
	private String username;
	private String source;
	private String destination;
	private String travelDate;
	private String trainName;
	private String departureTime;
	private String arrivalTime;
	

	public TrainTicket(int pnrNo, String name, String gender, int age, int seatNo, String coach, String seatType,
			int trainNo, String username, String source, String destination, String travelDate, String trainName,
			String departureTime, String arrivalTime) {
		super();
		this.pnrNo = pnrNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNo = seatNo;
		this.coach = coach;
		this.seatType = seatType;
		this.trainNo = trainNo;
		this.username = username;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.trainName = trainName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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
	
	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
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

	@Override
	public String toString() {
		return "TrainTicket [pnrNo=" + pnrNo + ", name=" + name + ", gender=" + gender + ", age=" + age + ", seatNo="
				+ seatNo + ", coach=" + coach + ", seatType=" + seatType + ", trainNo=" + trainNo + ", username="
				+ username + ", source=" + source + ", destination=" + destination + ", travelDate=" + travelDate
				+ ", trainName=" + trainName + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, arrivalTime, coach, departureTime, destination, gender, name, pnrNo, seatNo, seatType,
				source, trainName, trainNo, travelDate, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainTicket other = (TrainTicket) obj;
		return age == other.age && Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(coach, other.coach)
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(destination, other.destination)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name) && pnrNo == other.pnrNo
				&& seatNo == other.seatNo && Objects.equals(seatType, other.seatType)
				&& Objects.equals(source, other.source) && Objects.equals(trainName, other.trainName)
				&& trainNo == other.trainNo && Objects.equals(travelDate, other.travelDate)
				&& Objects.equals(username, other.username);
	}
	
	
	
}
