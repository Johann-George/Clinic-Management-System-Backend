package com.cms.backend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.dto.ConsultationRequestDto;
import com.cms.backend.dto.ValidateAppointmentResponseDto;
import com.cms.backend.model.Appointment;
import com.cms.backend.model.Consultation;
import com.cms.backend.model.Prescription;
import com.cms.backend.model.PrescriptionLabTest;
import com.cms.backend.model.PrescriptionLabTest.Status;
import com.cms.backend.model.PrescriptionMedicine;
import com.cms.backend.repo.IAppointmentRepo;
import com.cms.backend.repo.IConsultationRepo;
import com.cms.backend.repo.IPrescriptionLabTestRepo;
import com.cms.backend.repo.IPrescriptionMedicineRepo;
import com.cms.backend.repo.IPrescriptionRepo;

@Service
public class ConsultationServiceImpl implements IConsultationService {
	
	private final IAppointmentRepo appointmentRepo;
	private final IConsultationRepo consultationRepo;
	private final IPrescriptionRepo prescriptionRepo;
	private final IPrescriptionMedicineRepo prescriptionMedicineRepo;
	private final IPrescriptionLabTestRepo prescriptionLabTestRepo;
	
	@Autowired
	public ConsultationServiceImpl(IAppointmentRepo appointmentRepo, IConsultationRepo consultationRepo, IPrescriptionRepo prescriptionRepo, IPrescriptionMedicineRepo prescriptionMedicineRepo, IPrescriptionLabTestRepo prescriptionLabTestRepo) {
		this.appointmentRepo = appointmentRepo;
		this.consultationRepo = consultationRepo;
		this.prescriptionRepo = prescriptionRepo;
		this.prescriptionMedicineRepo = prescriptionMedicineRepo;
		this.prescriptionLabTestRepo = prescriptionLabTestRepo;
	}

	@Override
	public ValidateAppointmentResponseDto validateAppointment(String tokenNo) {
		ValidateAppointmentResponseDto response = null;
		try {
			Appointment appointment = appointmentRepo.findByTokenNo(tokenNo);
			if(appointment == null) {
				response = new ValidateAppointmentResponseDto(null,"Invalid token number");
				throw new IllegalArgumentException("Token Number does not exist");
			}
			if(!LocalDate.now().equals(appointment.getAppointmentDate())) {
				response = new ValidateAppointmentResponseDto(null,"Wrong date for appointment");
				throw new IllegalArgumentException("Wrong date for appointment");
			}
			response = new ValidateAppointmentResponseDto(appointment.getAppointmentId(),"Appointment validation successful");
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public String saveConsultation(ConsultationRequestDto consultationRequestDto) {
		try {
			//Storing values inside the consultation table
			Appointment savedAppointment = appointmentRepo.getReferenceById(consultationRequestDto.getAppointmentId());
			Consultation consultation = new Consultation();
			consultation.setAppointment(savedAppointment);
			consultation.setDiagnosis(consultationRequestDto.getDiagnosisDetails());
			Consultation savedConsultation = consultationRepo.save(consultation);
			if(savedConsultation == null) {
				throw new RuntimeException("The consultation was not successfully saved");
			}

			//Storing values inside the prescription table
			Prescription prescription = new Prescription();
			prescription.setConsultation(consultation);
			Prescription savedPrescription = prescriptionRepo.save(prescription);
			if(savedPrescription == null) {
				throw new RuntimeException("The prescription was not successfully saved");
			}

			for(PrescriptionMedicine prescriptionMedicine: consultationRequestDto.getPrescribedMedicines()) {
				System.out.println("Medicine Name:"+prescriptionMedicine.getMedicineName());
				System.out.println("Dosage:"+prescriptionMedicine.getDosage());
			}
			//Storing values inside Prescription Medicine table
			for(PrescriptionMedicine prescriptionMedicine: consultationRequestDto.getPrescribedMedicines()) {
				prescriptionMedicine.setPrescription(savedPrescription);
				PrescriptionMedicine savedPrescriptionMedicine = prescriptionMedicineRepo.save(prescriptionMedicine);
				if(savedPrescriptionMedicine == null) {
					throw new RuntimeException("The prescribed medicine was not successfully saved");
				}
			}
			
			//Storing values inside Prescription Lab Test table
			for(PrescriptionLabTest prescriptionLabTest: consultationRequestDto.getPrescribedLabTests()) {
				prescriptionLabTest.setPrescription(savedPrescription);
				prescriptionLabTest.setStatus(Status.PENDING);
				PrescriptionLabTest savedPrescriptionLabTest = prescriptionLabTestRepo.save(prescriptionLabTest);
				if(savedPrescriptionLabTest == null) {
					throw new RuntimeException("The prescribed lab test was not successfully saved");
				}
			}
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return "Consultation successful";
	}

}
