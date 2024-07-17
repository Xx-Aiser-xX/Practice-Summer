package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Dto.ClientDto;
import org.example.practice.Repositories.ClientRepository;
import org.example.practice.Repositories.LoyaltyCardRepository;
import org.example.practice.Table.Client;
import org.example.practice.Table.LoyaltyCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements BaseService<ClientDto>{

    @PersistenceContext
    private EntityManager entityManager;
    private final ClientRepository clientRepository;
    private final LoyaltyCardRepository loyaltyCardRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, LoyaltyCardRepository loyaltyCardRepository) {
        this.clientRepository = clientRepository;
        this.loyaltyCardRepository = loyaltyCardRepository; // Инициализируем через конструктор
    }

    public List<Client> findAllClientsWithLoyaltyCard() {
        return clientRepository.findAllClientsWithLoyaltyCard();
    }

    @Transactional
    public String rewardTopClientsWithPoints(int points, int topN) {
        List<Client> topClients = clientRepository.findTopClientsByOrderCount(topN);

        for (Client client : topClients) {
            client.getLoyaltyCard().setPoints(client.getLoyaltyCard().getPoints() + points);
            entityManager.merge(client);
        }

        return "Добавлено " + points + " баллов " + topN + "самым активным клиентам.";
    }

    @Transactional
    public void updateClientStatusesBasedOnTotalSpent() {
        List<Object[]> totalSpentByClients = clientRepository.findTotalSpentByClients();

        for (Object[] result : totalSpentByClients) {
            Integer clientId = (Integer) result[0];
            Double totalSpent = (Double) result[1];

            Client client = clientRepository.findById(clientId);
            if (client == null) {
                // Если клиента с таким ID не существует - бросаем исключение
                throw new EntityNotFoundException("Client not found with id: " + clientId);
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

            loyaltyCardRepository.update(card);
        }
    }

    @Transactional
    @Override
    public void create(ClientDto clientDto) {
        entityManager.persist(clientDto);
    }

    @Transactional
    @Override
    public List<ClientDto> getAll() {
        return entityManager.createQuery("from Client", ClientDto.class).getResultList();
    }

    @Transactional
    @Override
    public ClientDto getById(int id) {
        return entityManager.find(ClientDto.class, id);
    }

    @Transactional
    @Override
    public void update(ClientDto clientDto) {
        entityManager.merge(clientDto);
    }
}
