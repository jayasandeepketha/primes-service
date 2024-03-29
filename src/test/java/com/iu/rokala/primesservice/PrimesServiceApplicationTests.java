package com.iu.rokala.primesservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.iu.rokala.primesservice.service.PrimesService;

@SpringBootTest
class PrimesServiceApplicationTests {

	@Test
	void contextLoads() {
	}

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
