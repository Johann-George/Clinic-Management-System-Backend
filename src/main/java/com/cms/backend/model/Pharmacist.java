package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pharmacist")
public class Pharmacist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pharmacist_id", nullable = false)
	private Integer pharmacistId;

	@OneToOne
	@JoinColumn(name="staff_id", nullable = false)
	private Staff staff;

	public Pharmacist() {
		super();
	}
	
	public Integer getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(Integer pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

		
}
