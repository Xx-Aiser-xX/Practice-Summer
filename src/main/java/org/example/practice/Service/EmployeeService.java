package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Dto.EmployeeDto;
import org.example.practice.Table.Employee;
import org.example.practice.Repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchOfTheOrganizationService branchService;
    private final ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           BranchOfTheOrganizationService branchService,
                           ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.branchService = branchService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public String increaseSalariesForMostProfitableBranch() {
        List<Object[]> branchProfits = branchService.findBranchProfits();
        if (branchProfits.isEmpty()) {
            throw new IllegalStateException("No branches found or no profits calculated.");
        }

        String mostProfitableBranchName = (String) branchProfits.get(0)[0];

        employeeRepository.updateEmployeeSalariesByBranchName(mostProfitableBranchName);

        return mostProfitableBranchName;
    }
}

