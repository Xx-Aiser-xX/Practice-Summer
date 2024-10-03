package org.example.practice.controller;

import org.example.practice.dto.ClientDto;
import org.example.practice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {


    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PutMapping("/reward-top-clients")
    public ResponseEntity<String> rewardTopClients() {
        String message = clientService.rewardTopClientsWithPoints(1000, 5);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/card")
    public List<ClientDto> getClientsWithLoyaltyCard() {
        return clientService.findAllClientsWithLoyaltyCard();
    }

    @PutMapping("/update-statuses")
    public ResponseEntity<String> updateClientStatuses() {
        clientService.updateClientStatusesBasedOnTotalSpent();
        return ResponseEntity.ok("Статусы клиентов были успешно обновлены");
    }
}
