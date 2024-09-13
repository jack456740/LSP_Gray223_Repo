package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class Wordcount {
    public static void main(String[] args) {
        String fileName = "src/org/howard/edu/lsp/assignment2/words.txt";
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.length() > 3) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

