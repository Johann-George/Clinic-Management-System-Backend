package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prescription_medicine")
public class PrescriptionMedicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pm_id", nullable = false)
	private Integer prescriptionMedicineId;
	
	@ManyToOne
	@JoinColumn(name="prescription_id", nullable = false)
	private Prescription prescription;
	
	@Column(name="medicine_name", nullable = false)
	private String medicineName;
	
	private String dosage;
	private String frequency;
	private String duration;
	
	public Integer getPrescriptionMedicineId() {
		return prescriptionMedicineId;
	}
	public void setPrescriptionMedicineId(Integer prescriptionMedicineId) {
		this.prescriptionMedicineId = prescriptionMedicineId;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
}
