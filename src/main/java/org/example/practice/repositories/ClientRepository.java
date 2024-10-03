package org.example.practice.repositories;

import org.example.practice.models.Client;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ClientRepository{
    List<Client> findAllClientsWithLoyaltyCard();
    List<Client> findTopClientsByOrderCount(int topN);
    List<Object[]> findTotalSpentByClients();
}