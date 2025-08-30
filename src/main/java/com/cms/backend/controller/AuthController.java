package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.LoginRequestDto;
import com.cms.backend.dto.LoginResponseDto;
import com.cms.backend.dto.UserDto;
import com.cms.backend.util.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto){
		try {
			Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
			String jwtToken = jwtUtil.generateJwtToken(authentication);
			var userDto = new UserDto();
			var loggedInUser = (User) authentication.getPrincipal();
			userDto.setUsername(loggedInUser.getUsername());
			return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), null, jwtToken));
		}
		catch(BadCredentialsException ex) {
			return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Invalid username and password");
		}
		catch(AuthenticationException ex) {
			return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Authentication failed");
		}
		catch(Exception ex) {
			return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
		}
	}
	
	private ResponseEntity<LoginResponseDto> buildErrorResponse(HttpStatus status, String message){
		return ResponseEntity.status(status).body(new LoginResponseDto(message, null, null));
	}

}
