package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.LoginRequestDto;
import com.cms.backend.dto.LoginResponseDto;
import com.cms.backend.service.IUserService;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
	
	private final IUserService userService;
	
	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
		LoginResponseDto response = userService.validateLogin(loginRequestDto.getUsername(), loginRequestDto.getPassword());
		if(response.getRole() == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		return ResponseEntity.ok(response);
	}

}
