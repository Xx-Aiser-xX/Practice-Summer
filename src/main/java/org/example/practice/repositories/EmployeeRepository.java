package org.example.practice.repositories;

import org.example.practice.models.Employee;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesByBranchName(String nameBranch);
    int updateEmployeeSalariesByBranchName(String nameBranch);

}


