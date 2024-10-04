package org.example.practice.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.practice.repositories.ClientRepository;
import org.example.practice.models.Client;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAllClientsWithLoyaltyCard() {
        try {
            Query query = entityManager.createQuery(
                    "SELECT c FROM Client c WHERE c.loyaltyCard IS NOT NULL");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Client> findTopClientsByOrderCount(int topN) {
        try {
            Query query = entityManager.createQuery(
                            "SELECT c FROM Client c " +
                                    "JOIN c.order o " +
                                    "WHERE c.loyaltyCard IS NOT NULL " +
                                    "GROUP BY c.id " +
                                    "ORDER BY COUNT(o.id) DESC")
                    .setMaxResults(topN);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object[]> findTotalSpentByClients() {
        try {
            Query query = entityManager.createQuery(
                    "SELECT c.id, SUM(o.listOfProduct.product.price * o.theQuantityOfTheProduct) " +
                            "FROM Client c " +
                            "JOIN c.order o " +
                            "JOIN o.listOfProduct lp " +
                            "JOIN lp.product p " +
                            "GROUP BY c.id");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}