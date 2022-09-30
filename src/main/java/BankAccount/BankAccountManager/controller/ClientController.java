package BankAccount.BankAccountManager.controller;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //@PostMapping("client/deposit")
   /* public ResponseEntity<Account> deposit (@RequestBody Integer amount) {
        //clientService.
    } */
}
