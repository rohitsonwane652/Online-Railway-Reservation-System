package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserData {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long userId;
	private String userName;
	private String email;
	private String password;
	private String role;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserData(long userId, String userName, String email, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
