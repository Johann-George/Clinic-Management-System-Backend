package com.cms.backend.service;

import java.util.List;

import com.cms.backend.model.Staff;

public interface IStaffService {

	List<Staff> getStaff();
	Staff getStaffByUsername(String staffName);
	void deleteStaffById(Integer staffId);
}
