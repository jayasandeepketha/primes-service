package com.iu.rokala.primesservice.service;

import java.io.IOException;

import com.iu.rokala.primesservice.model.Customer;

public interface IAuthenticationService {

	boolean register(Customer customer) throws IOException;

	boolean login(String username, String password) throws IOException;

}
