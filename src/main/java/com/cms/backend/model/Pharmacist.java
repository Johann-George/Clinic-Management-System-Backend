package com.cms.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="pharmacist")
public class Pharmacist {
	
	@Id
	@Column(name="pharmacist_id")
	private Integer pharmacistId;
	@OneToOne
	@JoinColumn(name="staff_id", referencedColumnName = "staff_id")
	private Staff staff;

	public Pharmacist() {
		super();
	}
	
//	public Pharmacist(Integer staffId, Integer userId, String name, String designation, LocalDate dob, Gender gender,
//			String address, Integer pharmacistId) {
//		super(staffId, userId, name, designation, dob, gender, address);
//		this.pharmacistId = pharmacistId;
//	}

	public Integer getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(Integer pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

		
}
