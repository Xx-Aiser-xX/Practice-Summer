package org.example.practice.Repositories;

import jakarta.persistence.Query;
import org.example.practice.Table.Employee;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepository extends BaseRepository<Employee> {

    public EmployeeRepository() {
        super(Employee.class);
    }

    public List<Employee> findEmployeesByBranchName(String nameBranch) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee e JOIN e.branchOfTheOrganization b WHERE b.nameBranch = :nameBranch",
                Employee.class);
        query.setParameter("nameBranch", nameBranch);
        return query.getResultList();
    }

    @Transactional
    public int updateEmployeeSalariesByBranchName(String nameBranch) {
        Query query = entityManager.createQuery(
                "UPDATE Employee e SET e.wages = e.wages * 1.05 WHERE e.branchOfTheOrganization.nameBranch = :nameBranch");
        query.setParameter("nameBranch", nameBranch);
        return query.executeUpdate();
    }

}