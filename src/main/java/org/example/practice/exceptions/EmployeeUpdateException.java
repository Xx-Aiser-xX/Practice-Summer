package org.example.practice.exceptions;

public class EmployeeUpdateException extends RuntimeException {
    public EmployeeUpdateException(String branchName) {
        super("Failed to update employees' salaries for branch: " + branchName);
    }
}