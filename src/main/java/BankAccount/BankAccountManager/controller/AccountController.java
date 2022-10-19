package BankAccount.BankAccountManager.controller;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.AccountRequest;
import BankAccount.BankAccountManager.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping(path = "account/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> deposit (@RequestBody AccountRequest depositRequest) {
        Account account = accountService.deposit(depositRequest.getAccountId(),depositRequest.getAmount());
        return ResponseEntity.status(OK).body(account) ;
    }

    @PostMapping(path = "account/withDraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> withDraw (@RequestBody AccountRequest withdrawRequest) {
        Account account = accountService.withDraw(withdrawRequest.getAccountId(), withdrawRequest.getAmount());
        return ResponseEntity.status(OK).body(account) ;
    }

}
