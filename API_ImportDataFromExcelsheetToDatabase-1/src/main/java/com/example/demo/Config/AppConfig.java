package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Security.JwtAuthenticationFilter;

@Configuration
public class AppConfig {

	@Autowired
	private AuthenticationEntryPoint point;

	@Autowired
	private JwtAuthenticationFilter filter;

	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// configuration

		httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
						.requestMatchers("/auth/login").permitAll().anyRequest().authenticated())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}
}

//@Configuration
//public class AppConfig {
//
//	@Autowired
//	private JwtAuthenticationEntryPoint point;
//	@Autowired
//	private JwtAuthenticationFilter filter;
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests().requestMatchers("/test").authenticated()
//				.requestMatchers("/auth/login").permitAll().anyRequest().authenticated().and()
//				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}
//
//}