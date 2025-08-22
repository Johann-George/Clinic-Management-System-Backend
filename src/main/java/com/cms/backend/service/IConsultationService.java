package com.cms.backend.service;

import com.cms.backend.dto.ValidateAppointmentResponseDto;

public interface IConsultationService {
	
	ValidateAppointmentResponseDto validateAppointment(String tokenNo);

}
