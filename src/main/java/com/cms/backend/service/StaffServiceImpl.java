package com.cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.Staff;
import com.cms.backend.repo.IStaffRepo;

@Service
public class StaffServiceImpl implements IStaffService {
	
	private final IStaffRepo adminRepo;
	
	@Autowired
	public StaffServiceImpl(IStaffRepo adminRepo) {
		this.adminRepo = adminRepo;
	}

	@Override
	public List<Staff> getStaff() {
		List<Staff> staffList = adminRepo.findAll();
		return staffList;
	}

}
