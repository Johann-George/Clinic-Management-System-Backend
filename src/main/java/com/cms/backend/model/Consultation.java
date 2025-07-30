package com.cms.backend.model;

import java.time.LocalDate;
import java.util.List;

public class Consultation {

	private String consultationId;
	private String patientId;
	private String diagnosis;
	private LocalDate consultationDate;
	private List<String> medicine;
	private List<String> labTest;
	public String getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(String consultationId) {
		this.consultationId = consultationId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public LocalDate getConsultationDate() {
		return consultationDate;
	}
	public void setConsultationDate(LocalDate consultationDate) {
		this.consultationDate = consultationDate;
	}
	public List<String> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<String> medicine) {
		this.medicine = medicine;
	}
	public List<String> getLabTest() {
		return labTest;
	}
	public void setLabTest(List<String> labTest) {
		this.labTest = labTest;
	}
	
	
	
}
