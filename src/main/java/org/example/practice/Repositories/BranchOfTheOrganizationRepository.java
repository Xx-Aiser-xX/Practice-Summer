package org.example.practice.Repositories;

import org.example.practice.Table.BranchOfTheOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOfTheOrganizationRepository extends JpaRepository<BranchOfTheOrganization, String> {

    @Query("SELECT b.nameBranch AS nameBranch, SUM(p.price * o.theQuantityOfTheProduct) AS profit " +
            "FROM Order o " +
            "JOIN o.listOfProduct lp " +
            "JOIN lp.product p " +
            "JOIN lp.manufactures m " +
            "JOIN m.employee e " +
            "JOIN e.branchOfTheOrganization b " +
            "GROUP BY b.nameBranch " +
            "ORDER BY profit DESC")
    List<Object[]> findBranchProfits();


}
