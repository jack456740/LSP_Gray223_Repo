package org.howard.edu.lsp.finalexam.question2;

import java.util.Random;

public class JavaRandomNumber implements RandomNumberStrategy {
    private final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(Integer.MAX_VALUE) + 1; // Ensures positive integers
    }
}
