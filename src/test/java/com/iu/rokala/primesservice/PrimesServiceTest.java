package com.iu.rokala.primesservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.iu.rokala.primesservice.service.PrimesService;

class PrimesServiceTest {

	PrimesService primes = new PrimesService();
	@Test
	void _45() {
		int n =45;
		boolean expected = false;
		boolean actual = primes.isPrime(n);
		assertEquals(expected, actual);
	}
	
	@Test
	void _532893258045L() {
		long n =532893258045L;
		boolean expected = false;
		boolean actual = primes.isPrime(n);
		assertEquals(expected, actual);
	}
	
	@Test
	void _285191() {
		long n =285191;
		boolean expected = true;
		boolean actual = primes.isPrime(n);
		assertEquals(expected, actual);
	}

}
