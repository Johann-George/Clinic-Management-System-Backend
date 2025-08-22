package com.cms.backend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.dto.ValidateAppointmentResponseDto;
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

}
