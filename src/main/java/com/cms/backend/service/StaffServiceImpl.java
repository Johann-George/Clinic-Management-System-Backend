package com.cms.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cms.backend.dto.StaffRequestDto;
import com.cms.backend.dto.UserDto;
import com.cms.backend.model.Staff;
import com.cms.backend.model.User;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IStaffRepo;
import com.cms.backend.repo.IUserRepo;

@Service
public class StaffServiceImpl implements IStaffService {
	
	private final IStaffRepo staffRepo;
	private final IUserRepo userRepo;
	
	@Autowired
	public StaffServiceImpl(IStaffRepo staffRepo, IUserRepo userRepo) {
		this.staffRepo = staffRepo;
		this.userRepo = userRepo;
	}

	@Override
	public List<Staff> getStaff() {
		List<Staff> staffList = staffRepo.findAll();
		return staffList;
	}

	@Override
	public Staff getStaffByUsername(String staffName) {
		Staff staff = staffRepo.findByUserUsername(staffName);
		if(staff==null) {
			throw new NullPointerException("Staff not found");
		}
		return staff;
	}

	@Override
	public void deleteStaffById(Integer staffId) {
		staffRepo.deleteById(staffId);
	}

	@Override
	public void registerStaff(StaffRequestDto staffDto) {
		UserDto userDto = staffDto.getUser();
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		if(staffDto.getDesignation().equals("Doctor")) {
			user.setRole(Role.ROLE_DOCTOR);
		}
		else if(staffDto.getDesignation().equals("Receptionist")) {
			user.setRole(Role.ROLE_RECEPTIONIST);
		}
		User savedUser = userRepo.save(user);
		Staff staff = new Staff();
		staff.setName(staffDto.getName());
		staff.setDob(staffDto.getDob());
		staff.setContactNo(staffDto.getContactNo());
		staff.setGender(staffDto.getGender());
		staff.setAddress(staffDto.getAddress());
		staff.setDesignation(staffDto.getDesignation());
		staff.setUser(savedUser);
		staffRepo.save(staff);
	}

	@Override
	public void updateStaff(Integer id, StaffRequestDto staffDto) {

		Staff existingStaff = staffRepo.getReferenceById(id);
		User existingUser = existingStaff.getUser();
	    // Update fields manually if needed
	    existingStaff.setName(staffDto.getName());
	    existingStaff.setDob(staffDto.getDob());
	    existingStaff.setGender(staffDto.getGender());
	    existingStaff.setAddress(staffDto.getAddress());
	    existingStaff.setDesignation(staffDto.getDesignation());
	    existingStaff.setContactNo(staffDto.getContactNo());
	    existingUser.setUsername(staffDto.getUser().getUsername());
	    existingUser.setPassword(staffDto.getUser().getPassword());
	    userRepo.save(existingUser);
	    staffRepo.save(existingStaff); // Persist the updated entity
	}

}
