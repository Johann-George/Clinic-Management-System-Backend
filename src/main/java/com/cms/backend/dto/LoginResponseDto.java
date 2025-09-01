package com.cms.backend.dto;

public class LoginResponseDto {
	
	private String message;
	private UserResponseDto user;
	private String jwtToken;
	
	public LoginResponseDto(String message, UserResponseDto user, String jwtToken) {
		this.message = message;
		this.user= user;
		this.jwtToken = jwtToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserResponseDto getUser() {
		return user;
	}

	public void setUser(UserResponseDto user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
