package com.cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.Staff;
import com.cms.backend.repo.IStaffRepo;

@Service
public class StaffServiceImpl implements IStaffService {
	
	private final IStaffRepo staffRepo;
	
	@Autowired
	public StaffServiceImpl(IStaffRepo staffRepo) {
		this.staffRepo = staffRepo;
	}

	@Override
	public List<Staff> getStaff() {
		List<Staff> staffList = staffRepo.findAll();
		return staffList;
	}

	@Override
	public Staff getStaffByUsername(String staffName) {
		return staffRepo.findByUserUsername(staffName);
	}

	@Override
	public void deleteStaffById(Integer staffId) {
		staffRepo.deleteById(staffId);
	}

}
