
package org.example.practice.Repositories;

import org.example.practice.Table.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e JOIN e.branchOfTheOrganization b WHERE b.nameBranch = :nameBranch")
    List<Employee> findEmployeesByBranchName(@Param("nameBranch") String nameBranch);

    @Modifying
    @Query("UPDATE Employee e SET e.wages = e.wages * 1.05 WHERE e.branchOfTheOrganization.nameBranch = :nameBranch")
    int updateEmployeeSalariesByBranchName(@Param("nameBranch") String nameBranch);

}
