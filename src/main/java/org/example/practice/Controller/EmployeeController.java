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

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/g{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(id);
        employeeService.update(employeeDto);
    }

    @PutMapping("/increase-salaries")
    public ResponseEntity<String> increaseSalariesForMostProfitableBranch() {
        try {
            // Получаем название филиала
            String branchName = employeeService.increaseSalariesForMostProfitableBranch();
            String message = "Зарплата сотрудников в филиале " + branchName + " поднята на 5%";
            return ResponseEntity.ok(message);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }

}
