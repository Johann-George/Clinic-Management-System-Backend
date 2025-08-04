package com.cms.backend.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name="appointment_id", nullable = false)
	private Integer appointmentId;

	@OneToOne
	@JoinColumn(name="patient_id", nullable = false)
	private Patient patient;

	@OneToOne
	@JoinColumn(name="receptionist_id", nullable = false)
	private Receptionist receptionist;

	@OneToOne
	@JoinColumn(name="doctor_id", nullable = false)
	private Doctor doctor;
	private LocalDateTime date;
	@Column(name="appointment_time")
	private LocalTime appointmentTime;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		PENDING,
		COMPLETED
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
		
}
