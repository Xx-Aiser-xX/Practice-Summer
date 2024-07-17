package org.example.practice.Controller;

import org.example.practice.Dto.EmployeeDto;
import org.example.practice.Table.Employee;
import org.example.practice.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping("/increase-salaries")
    public ResponseEntity<String> increaseSalariesForMostProfitableBranch() {
        try {
            String branchName = employeeService.increaseSalariesForMostProfitableBranch();
            String message = "Зарплата сотрудников в филиале " + branchName + " поднята на 5%";
            return ResponseEntity.ok(message);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }
}


