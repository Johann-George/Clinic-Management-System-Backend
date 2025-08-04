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
@Table(name="receptionist")
public class Receptionist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="receptionist_id", nullable = false)
	private Integer receptionistId;

	@OneToOne
	@JoinColumn(name="staff_id", nullable = false)
	private Staff staff;

	public Integer getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Integer receptionistId) {
		this.receptionistId = receptionistId;
	}

}
