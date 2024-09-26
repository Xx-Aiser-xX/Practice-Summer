package org.example.practice.service;

import org.example.practice.exceptions.BranchNotFoundException;
import org.example.practice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchOfTheOrganizationService branchService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           BranchOfTheOrganizationService branchService) {
        this.employeeRepository = employeeRepository;
        this.branchService = branchService;
    }

    @Transactional
    public String increaseSalariesForMostProfitableBranch() {
        List<Object[]> branchProfits = branchService.findBranchProfits();

        if (branchProfits.isEmpty()) {
            throw new BranchNotFoundException("No branches found or no profits calculated.");
        }

        String mostProfitableBranchName = (String) branchProfits.get(0)[0];

        employeeRepository.updateEmployeeSalariesByBranchName(mostProfitableBranchName);

        return mostProfitableBranchName;
    }
}

