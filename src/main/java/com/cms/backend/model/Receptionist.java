package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="receptionist")
public class Receptionist {

	@Id
	@Column(name="receptionist_id")
	private Integer receptionistId;
	@OneToOne
	@JoinColumn(name="staff_id", referencedColumnName = "staff_id")
	private Staff staff;

	
//	public Receptionist(Integer staffId, Integer userId, String name, String designation, LocalDate dob, Gender gender,
//			String address, Integer receptionistId) {
//		super(staffId, userId, name, designation, dob, gender, address);
//		this.receptionistId = receptionistId;
//	}

	public Integer getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Integer receptionistId) {
		this.receptionistId = receptionistId;
	}

}
