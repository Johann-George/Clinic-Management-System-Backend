package com.cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.Staff;
import com.cms.backend.repo.IAdminRepo;

@Service
public class AdminServiceImpl implements IAdminService {
	
	private final IAdminRepo adminRepo;
	
	@Autowired
	public AdminServiceImpl(IAdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}

	@Override
	public List<Staff> getStaff() {
		List<Staff> staffList = adminRepo.findAll();
		return staffList;
	}

}
