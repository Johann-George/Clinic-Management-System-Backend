package com.cms.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cms.backend.model.Staff;
import com.cms.backend.service.IAdminService;

@RestController
@RequestMapping("/api/v1/staff")
public class AdminController {
	
	private final IAdminService adminService;
	
	@Autowired
	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping
	public List<Staff> getAllStaff(){
		List<Staff> staffList = adminService.getStaff();
		return staffList;
	}

}
