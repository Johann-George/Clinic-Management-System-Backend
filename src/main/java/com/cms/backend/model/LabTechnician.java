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
@Table(name="labtechnician")
public class LabTechnician {

	@Id
	@Column(name="technician_id")
	private Integer technicianId;
	@OneToOne
	@JoinColumn(name="staff_id", referencedColumnName = "staff_id")
	private Staff staff;

	public LabTechnician() {
		super();
	}
	
//	public LabTechnician(Integer technicianId, Integer staffId, Integer userId, String name, String designation, LocalDate dob, Gender gender,
//			String address) {
//		super(staffId, userId, name, designation, dob, gender, address);
//		this.technicianId = technicianId;
//	}

	public Integer getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(Integer technicianId) {
		this.technicianId = technicianId;
	}
	
}
