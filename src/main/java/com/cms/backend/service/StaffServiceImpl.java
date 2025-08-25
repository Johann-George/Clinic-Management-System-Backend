package com.cms.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	public void registerStaff(Staff staff) {
		User user = staff.getUser();
		if(user == null || user.getUsername() == null || user.getPassword() == null) {
			throw new IllegalArgumentException("Username and password are required");
		}
		if(staff.getDesignation().equals("Doctor")) {
			user.setRole(Role.DOCTOR);
		}
		else if(staff.getDesignation().equals("Receptionist")) {
			user.setRole(Role.RECEPTIONIST);
		}
		User savedUser = userRepo.save(user);
		staff.setUser(savedUser);
		staffRepo.save(staff);
	}

	@Override
	public void updateStaff(Integer id, Staff staff) {

		Staff existingStaff = staffRepo.getReferenceById(id);
		
	    // Update fields manually if needed
	    existingStaff.setName(staff.getName());
	    existingStaff.setDob(staff.getDob());
	    existingStaff.setGender(staff.getGender());
	    existingStaff.setAddress(staff.getAddress());
	    existingStaff.setDesignation(staff.getDesignation());

	    staffRepo.save(existingStaff); // Persist the updated entity
	}

}
