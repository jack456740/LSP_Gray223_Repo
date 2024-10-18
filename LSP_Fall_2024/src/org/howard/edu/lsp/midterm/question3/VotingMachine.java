package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;

public class VotingMachine {
 private HashMap<String, Integer> candidates;

 public VotingMachine() {
     candidates = new HashMap<>();
 }

 // Add a new candidate with 0 votes
 public void addCandidate(String name) {
     candidates.put(name, 0);
 }

 // Increment vote count for the candidate
 public void castVote(String name) {
     if (candidates.containsKey(name)) {
         candidates.put(name, candidates.get(name) + 1);
     } else {
         System.out.println("Candidate not found.");
     }
 }

 // Return the number of votes each candidate has received
 @Override
 public String toString() {
     StringBuilder result = new StringBuilder();
     for (String name : candidates.keySet()) {
         result.append("Candidate: ").append(name)
               .append(", Votes: ").append(candidates.get(name)).append("\n");
     }
     return result.toString();
 }
}
