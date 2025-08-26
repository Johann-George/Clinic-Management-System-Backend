package com.cms.backend.dto;

public class AppointmentResponseDto {
	
	private String tokenNo;
	private String message;
	
	public AppointmentResponseDto(String tokenNo, String message) {
		this.tokenNo = tokenNo;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

}
