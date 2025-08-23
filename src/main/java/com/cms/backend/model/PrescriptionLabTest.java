package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prescription_lab_test")
public class PrescriptionLabTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pl_id", nullable = false)
	private Integer prescriptionLabTestId;
	
	@ManyToOne
	@JoinColumn(name="prescription_id", nullable = false)
	private Prescription prescription;
	
	@Column(name="lab_test_name", nullable = false)
	private String labTestName;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	private String result;

	public enum Status{
		PENDING,
		EXECUTING,
		COMPLETED
	}

	public Integer getPrescriptionLabTestId() {
		return prescriptionLabTestId;
	}

	public void setPrescriptionLabTestId(Integer prescriptionLabTestId) {
		this.prescriptionLabTestId = prescriptionLabTestId;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}
	
}
