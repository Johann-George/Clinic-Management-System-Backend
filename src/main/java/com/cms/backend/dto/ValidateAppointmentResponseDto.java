package com.cms.backend.dto;

public class ValidateAppointmentResponseDto {
	
	private Integer appointmentId;
	private String message;
	
	public ValidateAppointmentResponseDto(Integer appointmentId, String message) {
		this.appointmentId = appointmentId;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

}
