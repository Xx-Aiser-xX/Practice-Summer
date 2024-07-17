package org.example.practice.Repositories;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.example.practice.Table.Client;

import java.util.List;

@Repository
public class ClientRepository extends BaseRepository<Client> {

    public ClientRepository() {
        super(Client.class);
    }

    @Transactional
    public List<Client> findAllClientsWithLoyaltyCard() {
        try {
            TypedQuery<Client> query = entityManager.createQuery(
                    "SELECT c FROM Client c WHERE c.loyaltyCard IS NOT NULL", Client.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public List<Client> findTopClientsByOrderCount(int topN) {
        try {
            TypedQuery<Client> query = entityManager.createQuery(
                            "SELECT c FROM Client c " +
                                    "JOIN c.order o " +
                                    "WHERE c.loyaltyCard IS NOT NULL " +
                                    "GROUP BY c.id " +
                                    "ORDER BY COUNT(o.id) DESC", Client.class)
                    .setMaxResults(topN);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public List<Object[]> findTotalSpentByClients() {
        try {
            TypedQuery<Object[]> query = entityManager.createQuery(
                    "SELECT c.id, SUM(o.listOfProduct.product.price * o.theQuantityOfTheProduct) " +
                            "FROM Client c " +
                            "JOIN c.order o " +
                            "JOIN o.listOfProduct lp " +
                            "JOIN lp.product p " +
                            "GROUP BY c.id", Object[].class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}