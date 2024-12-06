package org.howard.edu.lsp.finalexam.question2;

/**
 * Client program to demonstrate the use of RandomNumberService.
 */
public class RandomNumberClient {
    public static void main(String[] args) {
        // Get the singleton instance of RandomNumberService
        RandomNumberService service = RandomNumberService.getInstance();

        // Use Java's built-in random number generator
        service.setStrategy(new JavaRandomNumber());
        System.out.println("Random number using JavaRandomNumber: " + service.getRandomNumber());

        // Use custom random number generator
        service.setStrategy(new CustomRandomNumber());
        System.out.println("Random number using CustomRandomNumber: " + service.getRandomNumber());
    }
}

//https://www.geeksforgeeks.org/strategy-design-pattern-in-java/
//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html