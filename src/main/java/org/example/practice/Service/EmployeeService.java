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
public class EmployeeService implements BaseService<EmployeeDto> {

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

    @Transactional
    @Override
    public void create(EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        entityManager.persist(employee);
    }

    @Transactional
    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public EmployeeDto getById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return convertToDto(employee);
    }

    @Transactional
    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        entityManager.merge(employee);
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    private EmployeeDto convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}