package com.cms.backend.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cms.backend.constants.ApplicationConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTTokenValidatorFilter extends OncePerRequestFilter{
	
	private final AntPathMatcher pathMatcher = new AntPathMatcher();
	private final java.util.List<String> publicPaths;
	
	@Autowired
	public JWTTokenValidatorFilter(List<String> publicPaths) {
		this.publicPaths = publicPaths;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(ApplicationConstants.JWT_HEADER);
		if(null != authHeader) {
			try {
				//Extract the JWT token
				String jwt = authHeader.substring(7); // Remove 'Bearer ' prefix
				Environment env = getEnvironment();
				if(null != env) {
					String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY, ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
					SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
					if(null != secretKey) {
						Claims claims = Jwts.parser().verifyWith(secretKey)
								.build().parseSignedClaims(jwt).getPayload();
						String username = String.valueOf(claims.get("name"));
						String role = String.valueOf(claims.get("role"));
						Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.createAuthorityList(role));
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}
			catch(ExpiredJwtException exception) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Token Expired");
				return;
			}
			catch(Exception exception) {
				throw new BadCredentialsException("Invalid Token received");
			}
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		return publicPaths.stream().anyMatch(publicPath -> pathMatcher.match(publicPath, path));
	}

}
