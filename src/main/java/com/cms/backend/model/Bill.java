package com.cms.backend.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Bill {
	
	private Patient patient;
	private Consultation consultation;
	private double consultationFee;
	private List<String> labTest;
	private List<String> medicine;
	private double totalAmount;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	public double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public List<String> getLabTest() {
		return labTest;
	}
	public void setLabTest(List<String> labTest) {
		this.labTest = labTest;
	}
	public List<String> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<String> medicine) {
		this.medicine = medicine;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
