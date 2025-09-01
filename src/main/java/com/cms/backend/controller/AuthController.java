package com.cms.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.LoginRequestDto;
import com.cms.backend.dto.LoginResponseDto;
import com.cms.backend.dto.PatientRequestDto;
import com.cms.backend.util.JwtUtil;

import jakarta.validation.Valid;

import com.cms.backend.dto.UserResponseDto;
import com.cms.backend.model.Patient;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IPatientRepo;
import com.cms.backend.repo.IUserRepo;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final IPatientRepo patientRepo;
	private final IUserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	private final CompromisedPasswordChecker compromisedPasswordChecker;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, IPatientRepo patientRepo, PasswordEncoder passwordEncoder, IUserRepo userRepo, CompromisedPasswordChecker compromisedPasswordChecker) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.patientRepo = patientRepo;
		this.passwordEncoder = passwordEncoder;
		this.userRepo = userRepo;
		this.compromisedPasswordChecker = compromisedPasswordChecker;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto){
		try {
			Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
			String jwtToken = jwtUtil.generateJwtToken(authentication);
			var userDto = new UserResponseDto();
			var loggedInUser = (Patient) authentication.getPrincipal();
			BeanUtils.copyProperties(loggedInUser, userDto);
			userDto.setRole(authentication.getAuthorities().iterator().next().getAuthority());
			return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), userDto, jwtToken));
		}
		catch(BadCredentialsException ex) {
			return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Invalid username and password");
		}
		catch(AuthenticationException ex) {
			return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Authentication failed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addPatient(@Valid @RequestBody PatientRequestDto patientDto) {
		
		CompromisedPasswordDecision decision = compromisedPasswordChecker.check(patientDto.getUser().getPassword());
		if(decision.isCompromised()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("user.password","Choose a strong password"));
		}
		Optional<com.cms.backend.model.User> existingUser = userRepo.findByUsername(patientDto.getUser().getUsername());
		if(existingUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("user.username","Username already exists"));
		}
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDto, patient);
		com.cms.backend.model.User user = new com.cms.backend.model.User();
		user.setUsername(patientDto.getUser().getUsername());
		user.setPassword(passwordEncoder.encode(patientDto.getUser().getPassword()));
		user.setRole(Role.ROLE_PATIENT);
		userRepo.save(user);
		patient.setUser(user);
		patientRepo.save(patient);
		return ResponseEntity.ok("Patient registered successfully");
	}

	private ResponseEntity<LoginResponseDto> buildErrorResponse(HttpStatus status, String message){
		return ResponseEntity.status(status).body(new LoginResponseDto(message, null, null));
	}

}
