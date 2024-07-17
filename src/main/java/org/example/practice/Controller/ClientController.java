package org.example.practice.Controller;


import org.example.practice.Dto.ClientDto;
import org.example.practice.Table.Client;
import org.example.practice.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @GetMapping("/reward-top-clients")
    public ResponseEntity<String> rewardTopClients() {
        String message = clientService.rewardTopClientsWithPoints(1000, 5);
        return ResponseEntity.ok(message);
    }

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/card")
    public List<Client> getClientsWithLoyaltyCard() {
        return clientService.findAllClientsWithLoyaltyCard();
    }

    @PostMapping("/update-statuses")
    public ResponseEntity<String> updateClientStatuses() {
        clientService.updateClientStatusesBasedOnTotalSpent();
        return ResponseEntity.ok("Статусы клиентов были успешно обновлены");
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PostMapping
    public void saveClient(@RequestBody ClientDto clientDto) {
        clientService.create(clientDto);
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable int id, @RequestBody ClientDto clientDto) {
        clientDto.setId(id);
        clientService.update(clientDto);
    }
}
