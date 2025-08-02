package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="labtest")
public class LabTest {
	
	@Id
	@Column(name="lab_test_id")
	private Integer labTestId;
	@Column(name="patient_id")
	private Integer patientId;
	@Column(name="technician_id")
	private Integer technicianId;
	@Column(name="test_type_id")
	private Integer testTypeId;
	private String result;
	@Enumerated(EnumType.STRING)
	private Status status;


	public enum Status{
		PENDING,
		EXECUTING,
		COMPLETED
	}


	public Integer getLabTestId() {
		return labTestId;
	}


	public void setLabTestId(Integer labTestId) {
		this.labTestId = labTestId;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}


	public Integer getTechnicianId() {
		return technicianId;
	}


	public void setTechnicianId(Integer technicianId) {
		this.technicianId = technicianId;
	}


	public Integer getTestTypeId() {
		return testTypeId;
	}


	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
}
