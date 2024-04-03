package com.iu.rokala.primesservice.service;

import java.io.IOException;

import com.iu.rokala.primesservice.model.Customer;

public interface IAuthenticationService {

	Customer register(Customer customer) throws IOException;

	// boolean login(String username, String password) throws IOException;

}
