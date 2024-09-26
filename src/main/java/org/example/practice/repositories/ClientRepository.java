package org.example.practice.repositories;

import org.example.practice.models.Client;

import java.util.List;

public interface ClientRepository{
    List<Client> findAllClientsWithLoyaltyCard();
    List<Client> findTopClientsByOrderCount(int topN);
    List<Object[]> findTotalSpentByClients();
}