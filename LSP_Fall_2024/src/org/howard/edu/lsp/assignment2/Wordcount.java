package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String FILE_NAME = "/resources/words.txt";  // Path relative to the project root
    private static final int MIN_WORD_LENGTH = 4;  // Words with fewer than 4 letters are considered trivial

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                WordCounter.class.getResourceAsStream(FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, wordCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printResults(wordCount);
    }

    private static void processLine(String line, Map<String, Integer> wordCount) {
        line = line.toLowerCase();
        Pattern pattern = Pattern.compile("[a-z]+(?:'[a-z]+)?");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() >= MIN_WORD_LENGTH) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
    }

    private static void printResults(Map<String, Integer> wordCount) {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%s\t%d%n", entry.getKey(), entry.getValue());
        }
    }
}
 
