package com.cms.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name="appointment_id", nullable = false)
	private Integer appointmentId;

	@ManyToOne
	@JoinColumn(name="patient_id", nullable = false)
	private Patient patient;

	@ManyToOne
	@JoinColumn(name="receptionist_id", nullable = false)
	private Receptionist receptionist;

	@ManyToOne
	@JoinColumn(name="doctor_id", nullable = false)
	private Doctor doctor;
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	@Column(name="appointment_time")
	private LocalTime appointmentTime;
	
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
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
}
