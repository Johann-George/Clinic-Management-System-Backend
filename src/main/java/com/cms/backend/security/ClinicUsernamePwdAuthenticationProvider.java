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
import com.cms.backend.model.Staff;
import com.cms.backend.model.User;
import com.cms.backend.model.User.Role;
import com.cms.backend.repo.IPatientRepo;
import com.cms.backend.repo.IStaffRepo;
import com.cms.backend.repo.IUserRepo;

@Component
public class ClinicUsernamePwdAuthenticationProvider implements AuthenticationProvider{
	
	private final IUserRepo userRepo;
	private final IPatientRepo patientRepo;
	private final IStaffRepo staffRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ClinicUsernamePwdAuthenticationProvider(IUserRepo userRepo, IPatientRepo patientRepo, IStaffRepo staffRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.staffRepo = staffRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: "+username));
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
		if(user.getRole() == Role.ROLE_PATIENT) {
			Patient patient = patientRepo.findByUserUsername(username);
			if(patient != null && passwordEncoder.matches(pwd, patient.getUser().getPassword())) {
				return new UsernamePasswordAuthenticationToken(patient, null, Collections.singletonList(authority));
			}
			else {
				throw new BadCredentialsException("Invalid username or password!");
			}
		}
		else {
			Staff staff = staffRepo.findByUserUsername(username);
			if(staff != null && passwordEncoder.matches(pwd, staff.getUser().getPassword())) {
				return new UsernamePasswordAuthenticationToken(staff, null, Collections.singletonList(authority));
			}
			else {
				throw new BadCredentialsException("Invalid username or password!");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	

}
