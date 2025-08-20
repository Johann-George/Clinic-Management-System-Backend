package com.cms.backend.dto;

public class AppointmentResponseDto {
	
	private String tokenNo;
	
	public AppointmentResponseDto(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

}
