package com.cms.backend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.Appointment;
import com.cms.backend.repo.IAppointmentRepo;

@Service
public class ConsultationServiceImpl implements IConsultationService {
	
	private final IAppointmentRepo appointmentRepo;
	
	@Autowired
	public ConsultationServiceImpl(IAppointmentRepo appointmentRepo) {
		this.appointmentRepo = appointmentRepo;
	}

	@Override
	public String validateAppointment(String tokenNo) {
		Appointment appointment = appointmentRepo.findByTokenNo(tokenNo);
		if(appointment == null) {
			throw new IllegalArgumentException("Token Number does not exist");
		}
		if(!LocalDate.now().equals(appointment.getAppointmentDate())) {
			throw new IllegalArgumentException("Wrong date for appointment");
		}
		return "Token No successfully validated";
	}

}
