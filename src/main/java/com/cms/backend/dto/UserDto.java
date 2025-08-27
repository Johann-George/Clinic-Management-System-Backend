package com.cms.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	@NotBlank(message = "Username cannot be empty")
	@Size(min=3, max=10, message = "Username length must be between 3 and 10")
	private String username;
	
	@NotBlank(message = "Password cannot be empty")
	@Size(min=5, max=15, message = "Password length must be between 5 and 15")
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
