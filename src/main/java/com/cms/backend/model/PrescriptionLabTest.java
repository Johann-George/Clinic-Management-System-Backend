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

@Entity
public class PrescriptionLabTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pl_id")
	private Integer prescriptionLabTestId;
	
	@ManyToOne
	@JoinColumn(name="prescription_id")
	private Prescription prescription;
	
	@ManyToOne
	@JoinColumn(name="lab_test_id")
	private LabTest labTest;
	
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

	public LabTest getLabTest() {
		return labTest;
	}

	public void setLabTest(LabTest labTest) {
		this.labTest = labTest;
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
	
}
