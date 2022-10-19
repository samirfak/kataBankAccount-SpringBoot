package BankAccount.BankAccountManager.controller;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.model.ClientRequest;
import BankAccount.BankAccountManager.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path = "client/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deposit (@RequestBody ClientRequest clientRequest) {
        Client client = clientService.deposit(clientRequest.getClientId(), clientRequest.getAmount());
        return ResponseEntity.status(OK).body(client) ;
    }

    @PostMapping(path = "client/withDraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> withDraw (@RequestBody ClientRequest clientRequest) {
        Client client = clientService.withDraw(clientRequest.getClientId(), clientRequest.getAmount());
        return ResponseEntity.status(OK).body(client) ;
    }
}
