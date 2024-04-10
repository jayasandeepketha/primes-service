package com.iu.rokala.primesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import com.iu.rokala.primesservice.service.IPrimesService;
import com.iu.rokala.primesservice.rabbitmq.MQSender;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

	@Autowired
	IPrimesService primesService;
	
	private final MQSender mqSender;
    	public PrimesController(IPrimesService primesService, MQSender mqSender){
		this.primesService = primesService;
		this.mqSender = mqSender;
	}
	
	@GetMapping("/{n}")
	public boolean isPrime(@PathVariable long n) {
		boolean result = primesService.isPrime(n);
        	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	String username = ((Jwt) principal).getSubject();
     	   	System.out.println(username);
        	mqSender.sendMessage(username, n, result);
        	return result;
	}
}
	
