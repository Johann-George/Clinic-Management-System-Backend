package com.cms.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cms.backend.model.Staff;
import com.cms.backend.service.IStaffService;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
	
	private final IStaffService staffService;
	
	@Autowired
	public StaffController(IStaffService staffService) {
		this.staffService = staffService;
	}
	
	@GetMapping("/all")
	public List<Staff> getAllStaff(){
		List<Staff> staffList = staffService.getStaff();
		return staffList;
	}
	
	@GetMapping("/{staffName}")
	public Staff getStaffByUsername(@PathVariable String staffName) {
		return staffService.getStaffByUsername(staffName);
	}
	
	@DeleteMapping("/{staffId}")
	public ResponseEntity<Void> deleteStaffById(@PathVariable Integer staffId) {
		staffService.deleteStaffById(staffId);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/register")
	public void addStaff(@RequestBody Staff staff) {
		staffService.registerStaff(staff);
	}
	
	@PutMapping("/{staffId}")
	public ResponseEntity<String> updateStaff(@PathVariable Integer staffId,@RequestBody Staff staff) {
		return staffService.updateStaff(staffId, staff);
	}

}
