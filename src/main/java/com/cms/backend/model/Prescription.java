package com.cms.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prescription")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prescription_id", nullable = false)
	private Integer prescriptionId;
	@OneToOne
	@JoinColumn(name="consultation_id", nullable = false)
	private Consultation consultation;
	
	@OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PrescriptionMedicine> prescriptionMedicine = new ArrayList<>();
	
	@OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PrescriptionLabTest> prescriptionLabTest = new ArrayList<>();

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public List<PrescriptionMedicine> getPrescriptionMedicine() {
		return prescriptionMedicine;
	}

	public void setPrescriptionMedicine(List<PrescriptionMedicine> prescriptionMedicine) {
		this.prescriptionMedicine = prescriptionMedicine;
	}

	public List<PrescriptionLabTest> getPrescriptionLabTest() {
		return prescriptionLabTest;
	}

	public void setPrescriptionLabTest(List<PrescriptionLabTest> prescriptionLabTest) {
		this.prescriptionLabTest = prescriptionLabTest;
	}

}
