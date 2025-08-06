package com.cms.backend.dto;

import com.cms.backend.model.User.Role;

public class LoginResponseDto {
	
	private String message;
	private Role role;
	private Object userDetails;
	
	public LoginResponseDto(String message, Role role, Object userDetails) {
		this.message = message;
		this.role = role;
		this.userDetails = userDetails;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Object getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Object userDetails) {
		this.userDetails = userDetails;
	}

}
