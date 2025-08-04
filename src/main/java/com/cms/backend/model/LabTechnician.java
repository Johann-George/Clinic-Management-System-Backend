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
@Table(name="labtechnician")
public class LabTechnician {

	@Id
	@Column(name="technician_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer technicianId;
	@OneToOne
	@JoinColumn(name="staff_id", nullable = false)
	private Staff staff;

	public LabTechnician() {
		super();
	}
	
	public Integer getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(Integer technicianId) {
		this.technicianId = technicianId;
	}
	
}
