package com.cms.backend.dto;

import java.time.LocalDate;

import com.cms.backend.model.Staff.Gender;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StaffRequestDto {
	
	@NotNull
	@Valid
	private UserDto user;
	
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Designation cannot be empty")
	private String designation;

	@NotNull(message = "Dob cannot be empty")
	private LocalDate dob;
	
	@NotNull(message = "Gender cannot be empty")
	private Gender gender;

	@NotBlank(message = "Address cannot be empty")
	private String address;

	@NotBlank(message = "Contact Number cannot be empty")
	@Pattern(regexp = "[0-9]{10}", message = "Contact number must contain only 10 digits")
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
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
