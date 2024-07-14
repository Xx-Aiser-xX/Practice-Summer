package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Table.Client;
import org.example.practice.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Transactional
    public void saveAllClient(List<Client> clients) {
        for (Client client : clients) {
            entityManager.persist(client);
        }
    }
//
//    @Transactional
//    public void update(Client client) {
//        entityManager.merge(client);
//    }
//
//    public Client findById(int id) {
//        return entityManager.find(Client.class, id);
//    }
//
//    public List<Client> findAll() {
//        return entityManager.createQuery("from Client", Client.class).getResultList();
//    }
//
//    @Transactional
//    public void deleteById(int id) {
//        Client client = findById(id);
//        if (client != null) {
//            entityManager.remove(client);
//        }
//    }

    public List<Client> findAllClientsWithLoyaltyCard() {
        return clientRepository.findAllClientsWithLoyaltyCard();
    }
}
