package com.cms.backend.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.backend.repo.IConsultationRepo;

public interface IConsultationService {
	
	String validateAppointment(String tokenNo);

}
