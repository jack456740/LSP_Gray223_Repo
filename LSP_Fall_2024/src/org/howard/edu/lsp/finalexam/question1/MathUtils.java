package org.howard.edu.lsp.finalexam.question1;

public class MathUtils {
    /**
     * Returns the factorial of a given non-negative integer.
     * If the input is negative, throws IllegalArgumentException.
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Returns true if the given number is a prime number, 
     * false otherwise.
     */
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the greatest common divisor (GCD) of two 
     * integers using the Euclidean algorithm. If either input 
     * is zero, returns the absolute value of the non-zero input.
     * If both inputs are zero, throws IllegalArgumentException.
     */
    public int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException(
"Both numbers cannot be zero");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
