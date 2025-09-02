package com.cms.backend.util;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.cms.backend.constants.ApplicationConstants;
import com.cms.backend.model.Patient;
import com.cms.backend.model.Staff;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final Environment env;
	
	@Autowired
	public JwtUtil(Environment env) {
		this.env = env;
	}
	
	public String generateJwtToken(Authentication authentication) {
		String jwt = "";
		String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY, ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
		SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		Object principal = authentication.getPrincipal();
		String username = null;
		String contactNo = null;

		if(principal instanceof Patient) {
			Patient patient = (Patient) principal;
			username = patient.getName();
			contactNo = patient.getContactNo();
		}
		else {
			Staff staff = (Staff) principal;
			username = staff.getName();
			contactNo = staff.getContactNo();
		}

		jwt = Jwts.builder().issuer("Techno King").subject("JWT Token")
				.claim("username", username)
				.claim("contactNumber", contactNo)
				.claim("role", authentication.getAuthorities().iterator().next().getAuthority())
				.issuedAt(new java.util.Date())
				.expiration(new java.util.Date((new java.util.Date()).getTime() + 60 * 60 * 1000))
				.signWith(secretKey).compact();
		return jwt;
	}

}
