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
@Table(name="prescription")
public class Prescription {
	
	@Id
	@Column(name="prescription_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prescriptionId;
	@OneToOne
	@JoinColumn(name="consultation_id")
	private Consultation consultation;
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

}
