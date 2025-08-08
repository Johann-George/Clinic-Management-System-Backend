package com.cms.backend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cms.backend.model.Staff;

public interface IStaffService {

	List<Staff> getStaff();
	Staff getStaffByUsername(String staffName);
	void deleteStaffById(Integer staffId);
	void registerStaff(Staff staff);
	ResponseEntity<String> updateStaff(Integer id, Staff staff);
}
