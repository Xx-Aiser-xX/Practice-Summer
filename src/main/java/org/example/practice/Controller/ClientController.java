package org.example.practice.Controller;


import org.example.practice.Table.Client;
import org.example.practice.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
//    @GetMapping
//    public List<Client> getAllClients() {
//        return clientService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Client getClientById(@PathVariable int id) {
//        return clientService.findById(id);
//    }
//
//    @PostMapping
//    public void saveClient(@RequestBody Client client) {
//        clientService.save(client);
//    }
//
//    @PutMapping("/{id}")
//    public void updateClient(@PathVariable int id, @RequestBody Client client) {
//        client.setId(id);
//        clientService.update(client);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteClient(@PathVariable int id) {
//        clientService.deleteById(id);
//    }

    @GetMapping("/card")
    public List<Client> getClientsWithLoyaltyCard() {
        return clientService.findAllClientsWithLoyaltyCard();
    }
}
