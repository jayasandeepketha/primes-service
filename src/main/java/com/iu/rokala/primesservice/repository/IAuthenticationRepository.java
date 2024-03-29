package com.iu.rokala.primesservice.repository;

import java.io.IOException;

import com.iu.rokala.primesservice.model.Customer;

public interface IAuthenticationRepository {

	boolean save(Customer customer) throws IOException;
	
	Customer findByUsername(String username) throws IOException;
}
