package com.cms.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ValidateAppointmentRequestDto {
	
	@NotBlank(message = "Token Number cannot be empty")
	private String tokenNo;

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

}
