package org.example.practice.service.impl;

import org.example.practice.dto.ClientDto;
import org.example.practice.exceptions.ClientNotFoundException;
import org.example.practice.models.Client;
import org.example.practice.models.LoyaltyCard;
import org.example.practice.repositories.ClientRepository;
import org.example.practice.repositories.generics.ReadRepository;
import org.example.practice.repositories.generics.UpdateRepository;
import org.example.practice.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private final UpdateRepository<Client> clientUpdateRepository;
    private final UpdateRepository<LoyaltyCard> loyaltyCardUpdateRepository;
    private final ReadRepository<Client> clientReadRepository;


    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UpdateRepository<Client> clientUpdateRepository,ModelMapper modelMapper,
                         UpdateRepository<LoyaltyCard> loyaltyCardUpdateRepository, ReadRepository<Client> clientReadRepository) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.clientUpdateRepository = clientUpdateRepository;
        this.loyaltyCardUpdateRepository = loyaltyCardUpdateRepository;
        this.clientReadRepository = clientReadRepository;
    }


    public List<ClientDto> findAllClientsWithLoyaltyCard() {
        List<Client> clients = clientRepository.findAllClientsWithLoyaltyCard();
        if (clients.isEmpty()) {
            throw new ClientNotFoundException(0);
        }
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public String rewardTopClientsWithPoints(int points, int topN) {
        List<Client> topClients = clientRepository.findTopClientsByOrderCount(topN);

        if (topClients.isEmpty()) {
            throw new ClientNotFoundException(0);
        }

        for (Client client : topClients) {
            client.getLoyaltyCard().setPoints(client.getLoyaltyCard().getPoints() + points);
            clientUpdateRepository.update(client);
        }

        return "Добавлено " + points + " баллов " + topN + " самым активным клиентам.";
    }

    @Transactional
    public void updateClientStatusesBasedOnTotalSpent() {
        List<Object[]> totalSpentByClients = clientRepository.findTotalSpentByClients();

        for (Object[] result : totalSpentByClients) {
            Integer clientId = (Integer) result[0];
            Double totalSpent = (Double) result[1];

            Client client = clientReadRepository.findById(Client.class, clientId);
            if (client == null) {
                throw new ClientNotFoundException(clientId);
            }

            LoyaltyCard card = client.getLoyaltyCard();
            if (card != null) {
                if (totalSpent >= 7000 && totalSpent < 12000) {
                    card.setOwnerStatus("Silver");
                } else if (totalSpent >= 12000 && totalSpent < 20000) {
                    card.setOwnerStatus("Gold");
                } else if (totalSpent >= 20000) {
                    card.setOwnerStatus("Platinum");
                }
            } else {
                throw new IllegalStateException("Client with id: " + clientId + " does not have a loyalty card.");
            }

            loyaltyCardUpdateRepository.update(card);
        }
    }
}
