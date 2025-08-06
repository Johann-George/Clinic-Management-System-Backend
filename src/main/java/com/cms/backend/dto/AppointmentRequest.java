package com.cms.backend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {
	
	private String doctorUsername;
	private String patientUsername;
	private String receptionistUsername;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	public String getDoctorUsername() {
		return doctorUsername;
	}
	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}
	public String getPatientUsername() {
		return patientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}
	public String getReceptionistUsername() {
		return receptionistUsername;
	}
	public void setReceptionistUsername(String receptionistUsername) {
		this.receptionistUsername = receptionistUsername;
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
