package com.cms.backend.dto;

import java.time.LocalDate;

import com.cms.backend.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientRequestDto {
	
	@NotNull
	@Valid
	private UserDto user;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotNull(message = "Dob cannot be empty")
	private LocalDate dob;
	
	@NotBlank(message = "Gender cannot be empty")
	private String gender;
	
	@NotBlank(message = "Address cannot be empty")
	private String address;
	
	@NotBlank(message = "Address cannot be empty")
	@Pattern(regexp = "[0-9]{10}")
	private String contactNo;

	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
