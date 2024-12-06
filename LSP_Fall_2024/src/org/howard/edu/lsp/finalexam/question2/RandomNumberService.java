package org.howard.edu.lsp.finalexam.question2;

/**
 * Singleton service for providing random number generation using the Strategy pattern.
 */
public class RandomNumberService {
    private static RandomNumberService instance;

    private RandomNumberStrategy strategy;

    // Private constructor to enforce singleton
    private RandomNumberService() {}

    /**
     * Gets the singleton instance of RandomNumberService.
     * 
     * @return the instance of RandomNumberService.
     */
    public static synchronized RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }

    /**
     * Sets the random number generation strategy.
     * 
     * @param strategy the RandomNumberStrategy to use.
     */
    public void setStrategy(RandomNumberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Generates a random number using the current strategy.
     * 
     * @return a random positive integer.
     * @throws IllegalStateException if the strategy is not set.
     */
    public int getRandomNumber() {
        if (strategy == null) {
            throw new IllegalStateException("Random number strategy not set.");
        }
        return strategy.generateRandomNumber();
    }
}
