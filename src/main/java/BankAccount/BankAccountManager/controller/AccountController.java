package BankAccount.BankAccountManager.controller;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("account/deposit")
    public ResponseEntity<Account> deposit (@RequestBody Integer accountId, Integer amount) {
        Account account = accountService.deposit(accountId, amount);
        return ResponseEntity.status(CREATED).body(account) ;
    }

    @PostMapping("client/withDraw")
    public ResponseEntity<Account> withDraw (@RequestBody Integer accountId, Integer amount) {
        Account account = accountService.withDraw(accountId, amount);
        return ResponseEntity.status(CREATED).body(account) ;
    }

}
