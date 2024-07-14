package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Table.Client;
import org.example.practice.Table.Employee;
import org.example.practice.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional
    public void saveAllEmployee(List<Employee> employees) {
        for (Employee employee : employees) {
            entityManager.persist(employee);
        }
    }

    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Transactional
    public void deleteById(int id) {
        Employee employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
