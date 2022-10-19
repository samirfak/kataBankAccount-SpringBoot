package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.times;

@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    private ClientService clientService ;

    @MockBean
    private ClientRepository clientRepository ;

    @MockBean
    private AccountService accountService ;

    @Test
    void make_withdraw_with_valid_client() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(new Client(1,"A",new Account(1,1)))) ;
        // When
        clientService.withDraw(1,20) ;
        // Then
        Mockito.verify(accountService,times(1)).withDraw(1,20) ;
    }

    @Test
    void make_find_by_account_with_valid_client_and_withdraw() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(new Client(1,"A",new Account(1,50)))) ;
        Mockito.when(accountService.withDraw(1,20)).thenReturn(new Account(1, 30));
        Account account = accountService.withDraw(1,20);
        // When
        clientService.withDraw(1,20) ;
        // Then
        Mockito.verify(clientRepository,times(1)).findByAccount(account) ;
    }

    @Test
    void make_deposit_with_valid_client() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(new Client(1,"A",new Account(1,1)))) ;
        // When
        clientService.deposit(1,20) ;
        // Then
        Mockito.verify(accountService,times(1)).deposit(1,20) ;
    }

    @Test
    void make_find_by_account_with_valid_client_and_deposit() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(new Client(1,"A",new Account(1,50)))) ;
        Mockito.when(accountService.deposit(1,20)).thenReturn(new Account(1, 30));
        Account account = accountService.deposit(1,20);
        // When
        clientService.deposit(1,20) ;
        // Then
        Mockito.verify(clientRepository,times(1)).findByAccount(account) ;
    }


    @Test
    void throw_illegalArgumentException_when_deposit_client_is_not_found() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> clientService.deposit(1, 2));
    }

    @Test
    void throw_illegalArgumentException_when_withdraw_client_is_not_found() {
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> clientService.withDraw(1, 2));
    }
}
