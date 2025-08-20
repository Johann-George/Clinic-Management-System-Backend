package com.cms.backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.dto.AppointmentRequest;
import com.cms.backend.model.Appointment;
import com.cms.backend.model.Patient;
import com.cms.backend.model.Staff;
import com.cms.backend.repo.IAppointmentRepo;
import com.cms.backend.repo.IPatientRepo;
import com.cms.backend.repo.IStaffRepo;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	private final IAppointmentRepo appointmentRepo;
	private final IPatientRepo patientRepo;
	private final IStaffRepo staffRepo;
	
	@Autowired
	public AppointmentServiceImpl(IAppointmentRepo appointmentRepo, IPatientRepo patientRepo, IStaffRepo staffRepo) {
		this.appointmentRepo = appointmentRepo;
		this.patientRepo = patientRepo;
		this.staffRepo = staffRepo;
	}

	@Override
	public Appointment bookAppointment(AppointmentRequest appointmentRequest) {
		Appointment appointment = new Appointment();
		System.out.println("Output:"+appointmentRequest.getDoctorUsername()+appointmentRequest.getPatientId());
		Optional<Patient> patientOpt = patientRepo.findById(appointmentRequest.getPatientId());
		if(patientOpt.isEmpty()) {
			throw new IllegalArgumentException("No patient found");
		}
		Patient patient = patientOpt.get();
		Staff staff = staffRepo.findByUserUsername(appointmentRequest.getDoctorUsername());
		if(staff == null) {
			throw new IllegalArgumentException("No doctor found");
		}
		appointment.setPatient(patient);
		appointment.setStaff(staff);
		appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
		appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
		//setting the token number
		String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		int countForDay = appointmentRepo.countByAppointmentDate(LocalDate.now()) + 1;
		String sequence = String.format("%03d", countForDay);
		appointment.setTokenNo("A"+datePart+"-"+sequence);
		appointmentRepo.save(appointment);
		return appointment;
	}

}
