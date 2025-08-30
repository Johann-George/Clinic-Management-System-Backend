package com.cms.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ClinicSecurityConfig {
	
	private final List<String> publicPaths;
	
	public ClinicSecurityConfig(List<String> publicPaths) {
		this.publicPaths = publicPaths;
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrfConfig -> csrfConfig.disable())
				.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()))
				.authorizeHttpRequests((requests) -> {
					publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
					requests.anyRequest().authenticated();
				})
			.formLogin(withDefaults())
			.httpBasic(withDefaults()).build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		var user1 = User.builder().username("sony").password("$2a$12$b6NB6AbPnWJKtFlSwbwmZu75TsNbuZ7HCy1y18VvrybU3tI0bo5RC").roles("USER").build();
		var user2 = User.builder().username("admin").password("$2a$12$gwqy/NwY6N4xk5uxkuGss.HL1f9unaGZE6OXe72WB7U6w8kkqtQhW").roles("USER","ADMIN").build();
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		System.out.println("Entered here");
		var daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		var providerManager = new ProviderManager(daoAuthenticationProvider);
		return providerManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
		config.setAllowedMethods(Collections.singletonList("*")); 
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.setAllowCredentials(true);
		config.setMaxAge(3600L);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

}
