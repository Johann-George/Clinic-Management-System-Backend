package com.cms.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.StaffRequestDto;
import com.cms.backend.model.Staff;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IStaffRepo;
import com.cms.backend.repo.IUserRepo;
import com.cms.backend.service.IStaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
	
	private final IStaffService staffService;
	private final IStaffRepo staffRepo;
	private final IUserRepo userRepo;
	private final CompromisedPasswordChecker compromisedPasswordChecker;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public StaffController(PasswordEncoder passwordEncoder, IStaffService staffService, IStaffRepo staffRepo, IUserRepo userRepo, CompromisedPasswordChecker compromisedPasswordChecker) {
		this.staffService = staffService;
		this.staffRepo = staffRepo;
		this.userRepo = userRepo;
		this.compromisedPasswordChecker = compromisedPasswordChecker;
		this.passwordEncoder = passwordEncoder;
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
	public ResponseEntity<String> deleteStaffById(@PathVariable Integer staffId) {
		staffService.deleteStaffById(staffId);
		return ResponseEntity.ok("Staff deleted successfully");
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addStaff(@Valid @RequestBody StaffRequestDto staffRequestDto) {
		CompromisedPasswordDecision decision = compromisedPasswordChecker.check(staffRequestDto.getUser().getPassword());
		if(decision.isCompromised()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("user.password","Choose a strong password"));
		}
		Optional<com.cms.backend.model.User> existingUser = userRepo.findByUsername(staffRequestDto.getUser().getUsername());
		if(existingUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("user.username","Username already exists"));
		}
		Staff staff = new Staff();
		BeanUtils.copyProperties(staffRequestDto, staff);
		com.cms.backend.model.User user = new com.cms.backend.model.User();
		user.setUsername(staffRequestDto.getUser().getUsername());
		user.setPassword(passwordEncoder.encode(staffRequestDto.getUser().getPassword()));
		String designation = staffRequestDto.getDesignation();
		if(designation.equalsIgnoreCase("doctor")) {
			user.setRole(Role.ROLE_DOCTOR);
		}
		else if(designation.equalsIgnoreCase("receptionist")) {
			user.setRole(Role.ROLE_RECEPTIONIST);
		}
		userRepo.save(user);
		staff.setUser(user);
		staffRepo.save(staff);
		return ResponseEntity.ok("Staff registered successfully");
		//staffService.registerStaff(staffRequestDto);
		//return ResponseEntity.ok("Staff registered successfully");
	}
	
	@PutMapping("/{staffId}")
	public ResponseEntity<String> updateStaff(@PathVariable Integer staffId,@RequestBody StaffRequestDto staff) {
		staffService.updateStaff(staffId, staff);
		return ResponseEntity.ok("Staff updated successfully");
	}

}
