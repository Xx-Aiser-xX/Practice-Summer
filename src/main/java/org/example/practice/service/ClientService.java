package org.example.practice.service;

import org.example.practice.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAllClientsWithLoyaltyCard();
    String rewardTopClientsWithPoints(int points, int topN);
    void updateClientStatusesBasedOnTotalSpent();
}
