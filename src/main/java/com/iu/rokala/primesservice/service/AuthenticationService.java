package com.iu.rokala.primesservice.service;

import java.io.IOException;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iu.rokala.primesservice.model.Customer;
import com.iu.rokala.primesservice.repository.IAuthenticationRepository;

@Service("authenticationService")
public class AuthenticationService implements IAuthenticationService, UserDetailsService {

	private IAuthenticationRepository authenticationRepository;

	public AuthenticationService(IAuthenticationRepository authenticationRepository) {
		this.authenticationRepository = authenticationRepository;
	}

	@Override
	public boolean register(Customer customer) throws IOException {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		String passwordEncoded = bc.encode(customer.getPassword());
		customer.setPassword(passwordEncoded);
		return authenticationRepository.save(customer);
	}

	@Override
	public boolean login(String username, String password) throws IOException {
		Customer customer = authenticationRepository.findByUsername(username);
		if (customer != null) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			if (bc.matches(password, customer.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Customer customer = authenticationRepository.findByUsername(username);
			if (customer == null) {
				throw new UsernameNotFoundException("");
			}
			return User.withUsername(username).password(customer.getPassword()).build();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
