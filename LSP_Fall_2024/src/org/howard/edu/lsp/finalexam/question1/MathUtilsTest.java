package org.howard.edu.lsp.finalexam.question1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Refrences JUnit 5 Documentation: https://junit.org/junit5/ Euclidean Algorithm for GCD: CLRS (3rd Edition), Chapter 31
//Prime Checking Algorithms: Introduction to Algorithms, CLRS https://www.geeksforgeeks.org/program-for-factorial-of-a-number/ fractorial for a number geekforgeeks
//https://www.geeksforgeeks.org/python-program-to-find-the-factorial-of-a-number-using-recursion/

public class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    // Test cases for factorial method
    @Test
    void factorial_returnsOne_whenInputIsZero() {
        assertEquals(1, mathUtils.factorial(0));
    }

    @Test
    void factorial_returnsOne_whenInputIsOne() {
        assertEquals(1, mathUtils.factorial(1));
    }

    @Test
    void factorial_returnsCorrectResult_forPositiveInput() {
        assertEquals(120, mathUtils.factorial(5));
    }

    @Test
    void factorial_throwsException_whenInputIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> mathUtils.factorial(-1)
        );
        assertEquals("Number must be non-negative", exception.getMessage());
    }

    // Test cases for isPrime method
    @Test
    void isPrime_returnsFalse_whenInputIsOne() {
        assertFalse(mathUtils.isPrime(1));
    }

    @Test
    void isPrime_returnsTrue_whenInputIsPrime() {
        assertTrue(mathUtils.isPrime(7));
    }

    @Test
    void isPrime_returnsFalse_whenInputIsNotPrime() {
        assertFalse(mathUtils.isPrime(8));
    }

    @Test
    void isPrime_handlesLargePrimeCorrectly() {
        assertTrue(mathUtils.isPrime(7919));
    }

    @Test
    void isPrime_handlesLargeNonPrimeCorrectly() {
        assertFalse(mathUtils.isPrime(8000));
    }

    // Test cases for gcd method
    @Test
    void gcd_returnsAbsoluteValue_whenOneInputIsZero() {
        assertEquals(10, mathUtils.gcd(10, 0));
        assertEquals(10, mathUtils.gcd(0, -10));
    }

    @Test
    void gcd_returnsGCD_forPositiveInputs() {
        assertEquals(6, mathUtils.gcd(54, 24));
    }

    @Test
    void gcd_returnsGCD_forNegativeInputs() {
        assertEquals(4, mathUtils.gcd(-12, -8));
    }

    @Test
    void gcd_throwsException_whenBothInputsAreZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> mathUtils.gcd(0, 0)
        );
        assertEquals("Both numbers cannot be zero", exception.getMessage());
    }

    @Test
    void gcd_returnsGCD_forOneNegativeOnePositive() {
        assertEquals(5, mathUtils.gcd(-25, 10));
    }
}
