package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	@Column(name="doctor_id")
	private Integer doctorId;
	private String specialization;
	@OneToOne
	@JoinColumn(name="staff_id", referencedColumnName = "staff_id")
	private Staff staff;
	
	public Doctor() {
		super();
	}

//	public Doctor(Integer doctorId, Integer staffId, Integer userId, String name, String designation, LocalDate dob, Gender gender, String address) {
//		super(staffId, userId, name, designation, dob, gender, address);
//		this.doctorId = doctorId;
//		this.setSpecialization(specialization);
//	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
