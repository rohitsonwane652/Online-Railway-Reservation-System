package com.casestudy.util;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


@Component
public class TrainInfoDto {
	
	@Id
	private Integer trainNo;
	private Integer trainId;
	private TrainDetail trainDetail;
	
	private Date trainDate;
	private int seatsAC;
	private int seatsSL;
	private int waitingSL;
	private int waitingAC;
	
	public TrainInfoDto(Integer trainNo, Integer trainId, TrainDetail trainDetail, Date trainDate, int seatsAC,
			int seatsSL, int waitingSL, int waitingAC) {
		super();
		this.trainNo = trainNo;
		this.trainId = trainId;
		this.trainDetail = trainDetail;
		this.trainDate = trainDate;
		this.seatsAC = seatsAC;
		this.seatsSL = seatsSL;
		this.waitingSL = waitingSL;
		this.waitingAC = waitingAC;
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
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public TrainDetail getTrainDetail() {
		return trainDetail;
	}
	public void setTrainDetail(TrainDetail trainDetail) {
		this.trainDetail = trainDetail;
	}
	public Date getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
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
