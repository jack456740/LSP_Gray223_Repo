package org.howard.edu.lsp.finalexam.question2;

public class CustomRandomNumber implements RandomNumberStrategy {
    private long seed = System.nanoTime();

    @Override
    public int generateRandomNumber() {
        // Linear congruential generator (LCG)
        seed = (seed * 6364136223846793005L + 1) & ((1L << 48) - 1);
        return (int) ((seed >>> 16) & Integer.MAX_VALUE) + 1; // Ensures positive integers
    }
}
