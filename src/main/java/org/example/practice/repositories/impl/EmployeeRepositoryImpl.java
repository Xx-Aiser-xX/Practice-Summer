package org.example.practice.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.practice.repositories.EmployeeRepository;
import org.example.practice.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findEmployeesByBranchName(String nameBranch) {
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e JOIN e.branchOfTheOrganization b WHERE b.nameBranch = :nameBranch");
        query.setParameter("nameBranch", nameBranch);
        return query.getResultList();
    }

    @Override
    public int updateEmployeeSalariesByBranchName(String nameBranch) {
        Query query = entityManager.createQuery(
                "UPDATE Employee e SET e.wages = e.wages * 1.05 WHERE e.branchOfTheOrganization.nameBranch = :nameBranch");
        query.setParameter("nameBranch", nameBranch);
        return query.executeUpdate();
    }

}


