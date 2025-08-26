package com.cms.backend.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentRequest {
	
	@NotBlank(message = "Doctor username cannot be empty")
	private String doctorUsername;
	
	@NotBlank(message = "Patient username cannot be empty")
	private String patientUsername;
	
	@NotNull(message = "Date cannot be empty")
	private LocalDate appointmentDate;
	
	@NotNull(message = "Time cannot be empty")
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
