// VotingMachineDriver.java
package org.howard.edu.lsp.midterm.question3;

public class VotingMachineDriver {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        
        vm.addCandidate("Alsobrooks");
        vm.castVote("Alsobrooks");
        
        vm.addCandidate("Hogan");
        vm.castVote("Hogan");
        vm.castVote("Alsobrooks");  // Another vote for Alsobrooks

        // Output the votes for each candidate
        System.out.println(vm.toString());
    }
}

