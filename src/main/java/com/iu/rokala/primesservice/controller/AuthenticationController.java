package com.iu.rokala.primesservice.controller;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.rokala.primesservice.model.Customer;
import com.iu.rokala.primesservice.service.IAuthenticationService;
import com.iu.rokala.primesservice.service.TokenService;

@RestController
public class AuthenticationController {

	private IAuthenticationService authenticationService;

	private AuthenticationManager authenticationManager;

	private TokenService tokenService;

	public AuthenticationController(IAuthenticationService authenticationService,
			AuthenticationManager authenticationManager, TokenService tokenService) {
		this.authenticationService = authenticationService;
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
	}

	@PostMapping("/register")
	public boolean register(@RequestBody Customer customer) {
		try {
			return authenticationService.register(customer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody Customer customer) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
		return tokenService.generateToken(authentication);
	}
}
