package com.cms.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.backend.dto.LoginResponseDto;
import com.cms.backend.model.Staff;
import com.cms.backend.model.User;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IPatientRepo;
import com.cms.backend.repo.IStaffRepo;
import com.cms.backend.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	private final IUserRepo userRepo;
	private final IPatientRepo patientRepo;
	private final IStaffRepo staffRepo;
	
	@Autowired
	public UserServiceImpl(IUserRepo userRepo, IPatientRepo patientRepo, IStaffRepo staffRepo) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.staffRepo = staffRepo;
	}

	@Override
	public Optional<User> findById(Integer userId) {
		return userRepo.findById(userId);
	}

	@Override
	public LoginResponseDto validateLogin(String username, String password) {
		User user = userRepo.findByUsernameAndPassword(username, password);
		if(user == null) {
			return new LoginResponseDto("Invalid username or password", null, null);
		}
		
		Object userDetails = null;
		
		if(user.getRole() == Role.PATIENT) {
			userDetails = patientRepo.findByUserUserId(user.getUserId());
		}
		else if(user.getRole() == Role.DOCTOR) {
			userDetails = staffRepo.findByUserUserId(user.getUserId());
		}
		else if(user.getRole() == Role.RECEPTIONIST) {
			userDetails = staffRepo.findByUserUserId(user.getUserId());
		}
		else if(user.getRole() == Role.PHARMACIST) {
			userDetails = staffRepo.findByUserUserId(user.getUserId());
		}
		else if(user.getRole() == Role.TECHNICIAN) {
			userDetails = staffRepo.findByUserUserId(user.getUserId());
		}
		return new LoginResponseDto("Login successful", user.getRole(), userDetails);
		
	}

}
