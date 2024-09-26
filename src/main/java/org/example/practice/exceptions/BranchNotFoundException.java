package org.example.practice.exceptions;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException(String branchName) {
        super("Branch with name " + branchName + " not found.");
    }
}