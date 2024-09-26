package org.example.practice.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.practice.repositories.BranchOfTheOrganizationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchOfTheOrganizationRepositoryImpl implements BranchOfTheOrganizationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
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
