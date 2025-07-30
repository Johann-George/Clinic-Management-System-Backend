package com.cms.backend.model;

public class User {
	
	private String username;
	private String password;
	private String role;
	private Staff staff;
	private Patient patient;
	
	public User(String username, String password, String role, Staff staff, Patient patient) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.staff = staff;
		this.patient = patient;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
