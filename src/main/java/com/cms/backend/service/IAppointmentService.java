package com.cms.backend.service;

import com.cms.backend.dto.AppointmentRequest;
import com.cms.backend.model.Appointment;

public interface IAppointmentService {

	Appointment bookAppointment(AppointmentRequest appointmentRequest);
	
}
