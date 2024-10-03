package org.example.practice.controller;

import org.example.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping("/increase_salaries")
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


