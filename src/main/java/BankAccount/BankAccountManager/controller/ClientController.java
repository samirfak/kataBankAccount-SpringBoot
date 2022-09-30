package BankAccount.BankAccountManager.controller;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("client/deposit")
    public ResponseEntity<Client> deposit (@RequestBody Integer clientId, Integer amount) {
        Client client = clientService.deposit(clientId, amount);
        return ResponseEntity.status(CREATED).body(client) ;
    }

    @PostMapping("client/withDraw")
    public ResponseEntity<Client> withDraw (@RequestBody Integer clientId, Integer amount) {
        Client client = clientService.withDraw(clientId, amount);
        return ResponseEntity.status(CREATED).body(client) ;
    }
}
