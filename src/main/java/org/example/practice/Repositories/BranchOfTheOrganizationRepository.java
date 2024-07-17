package org.example.practice.Repositories;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.practice.Table.BranchOfTheOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchOfTheOrganizationRepository extends BaseRepository<BranchOfTheOrganization>{

    public BranchOfTheOrganizationRepository() {
        super(BranchOfTheOrganization.class);
    }

    @Transactional
    public List<Object[]> findBranchProfits() {
        try {
            TypedQuery<Object[]> query = entityManager.createQuery(
                    "SELECT b.nameBranch AS nameBranch, SUM(p.price * o.theQuantityOfTheProduct) AS profit " +
                            "FROM Order o " +
                            "JOIN o.listOfProduct lp " +
                            "JOIN lp.product p " +
                            "JOIN lp.manufactures m " +
                            "JOIN m.employee e " +
                            "JOIN e.branchOfTheOrganization b " +
                            "GROUP BY b.nameBranch " +
                            "ORDER BY profit DESC",
                    Object[].class
            );
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
