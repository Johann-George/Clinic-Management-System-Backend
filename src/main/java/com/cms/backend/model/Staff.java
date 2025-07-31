package com.cms.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="staff")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Staff {
	
	@Id
	private Integer staffId;
	private Integer userId;
	private String name;
	private String designation;
	private LocalDate dob;
	private Gender gender;
	private String address;
	
	public enum Gender{
		MALE,
		FEMALE
	}
	
	public Staff(Integer staffId, Integer userId, String name, String designation, LocalDate dob, Gender gender, String address) {
		this.staffId = staffId;
		this.userId = userId;
		this.name = name;
		this.designation = designation;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

}
