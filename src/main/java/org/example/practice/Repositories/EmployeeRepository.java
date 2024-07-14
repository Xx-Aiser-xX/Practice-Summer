
package org.example.practice.Repositories;

import org.example.practice.Table.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // сотрудники с определённой должностью
    @Query("SELECT e FROM Employee e WHERE e.post = :post")
    List<Employee> findEmployeesByPost(@Param("post") String post);
}
