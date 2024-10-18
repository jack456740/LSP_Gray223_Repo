package org.howard.edu.lsp.midterm.question2;

public class CalculatorDriver {
    public static void main(String[] args) {
        // Test sum of two integers
        System.out.println(Calculator.sum(5, 10));  // Output: 15
        
        // Test sum of two double values
        System.out.println(Calculator.sum(3.5, 7.8));  // Output: 11.3
        
        // Test sum of an array of integers
        System.out.println(Calculator.sum(new int[]{1, 2, 3, 4, 5}));  // Output: 15
    }
}

