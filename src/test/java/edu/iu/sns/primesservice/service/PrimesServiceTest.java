package edu.iu.sns.primesservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primesService = new PrimesService();
    @Test
    void _45IsNotPrime(){
        int n = 45;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

}