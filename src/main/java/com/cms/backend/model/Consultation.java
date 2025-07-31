package com.cms.backend.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consultation")
public class Consultation {

	@Id
	private Integer consultationId;
	private Integer appointmentId;
	private String diagnosis;
	private LocalDate consultationDate;
	public Integer getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(Integer consultationId) {
		this.consultationId = consultationId;
	}
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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
	
}
