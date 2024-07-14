package org.example.practice.Repositories;

import org.example.practice.Table.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    // клиенты у которых есть карта лояльности
    @Query("SELECT c FROM Client c WHERE c.loyaltyCard IS NOT NULL")
    List<Client> findAllClientsWithLoyaltyCard();

    @Query("SELECT c.human.firstName, c.human.lastName, COUNT(o.id) " +
            "FROM Order o " +
            "JOIN o.client c " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(o.id) DESC")
    List<Object[]> findMostActiveClients();
}