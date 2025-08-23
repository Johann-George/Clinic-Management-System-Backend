package com.cms.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consultation")
public class Consultation {

	@Id
	@Column(name="consultation_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer consultationId;
	@OneToOne
	@JoinColumn(name="appointment_id", nullable = false)
	private Appointment appointment;
	private String diagnosis;

	public Integer getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(Integer consultationId) {
		this.consultationId = consultationId;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
}
