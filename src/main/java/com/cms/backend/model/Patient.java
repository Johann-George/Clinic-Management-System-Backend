package com.cms.backend.model;

import java.time.LocalDate;
import java.util.List;

public class Patient {
	
	private String patientId;
	private String name;
	private String contactNo;
	private String address;
	private LocalDate dob;
	private String gender;
	private List<Consultation> consultation;
	
	public Patient(String patientId, String name, String contactNo, String address, LocalDate dob, String gender,
			List<Consultation> consultation) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.consultation = consultation;
	}
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Consultation> getConsultation() {
		return consultation;
	}
	public void setConsultation(List<Consultation> consultation) {
		this.consultation = consultation;
	}
	
	

}
