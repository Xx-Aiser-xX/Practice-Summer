package org.example.practice.repositories;

import org.example.practice.models.Employee;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface EmployeeRepository {
    List<Employee> findEmployeesByBranchName(String nameBranch);
    int updateEmployeeSalariesByBranchName(String nameBranch);

}


