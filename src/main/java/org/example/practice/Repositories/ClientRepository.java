package org.example.practice.Repositories;

import org.example.practice.Table.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    // клиенты у которых есть карта лояльности
    @Query("SELECT c FROM Client c WHERE c.loyaltyCard IS NOT NULL")
    List<Client> findAllClientsWithLoyaltyCard();
}
