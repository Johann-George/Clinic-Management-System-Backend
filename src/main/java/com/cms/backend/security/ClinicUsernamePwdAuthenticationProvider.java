package com.cms.backend.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cms.backend.model.Patient;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IPatientRepo;

@Component
public class ClinicUsernamePwdAuthenticationProvider implements AuthenticationProvider{
	
	private final IPatientRepo patientRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ClinicUsernamePwdAuthenticationProvider(IPatientRepo patientRepo, PasswordEncoder passwordEncoder) {
		this.patientRepo = patientRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Patient patient = patientRepo.findByUserUsername(username);
		if(patient == null) {
			throw new UsernameNotFoundException("User details not found for the user: "+username);
		}
		Role role = patient.getUser().getRole();
		GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
		if(passwordEncoder.matches(pwd, patient.getUser().getPassword())) {
			return new UsernamePasswordAuthenticationToken(patient, null, Collections.singletonList(authority));
		} else {
			throw new BadCredentialsException("Invalid password!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	

}
