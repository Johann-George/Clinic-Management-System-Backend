package com.cms.backend.dto;

import java.util.List;

import com.cms.backend.model.PrescriptionLabTest;
import com.cms.backend.model.PrescriptionMedicine;

import jakarta.validation.constraints.NotBlank;

public class ConsultationRequestDto {
	
	private Integer appointmentId;
	
	@NotBlank(message = "Diagnosis cannot be empty")
	private String diagnosisDetails;
	private List<PrescriptionMedicine> prescribedMedicines;
	private List<PrescriptionLabTest> prescribedLabTests;

	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getDiagnosisDetails() {
		return diagnosisDetails;
	}
	public void setDiagnosisDetails(String diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}
	public List<PrescriptionMedicine> getPrescribedMedicines() {
		return prescribedMedicines;
	}
	public void setPrescribedMedicines(List<PrescriptionMedicine> prescribedMedicines) {
		this.prescribedMedicines = prescribedMedicines;
	}
	public List<PrescriptionLabTest> getPrescribedLabTests() {
		return prescribedLabTests;
	}
	public void setPrescribedLabTests(List<PrescriptionLabTest> prescribedLabTests) {
		this.prescribedLabTests = prescribedLabTests;
	}

}
