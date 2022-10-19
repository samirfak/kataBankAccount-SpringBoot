package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;


    @Test
    void throw_illegalArgumentException_when_withdraw_account_is_not_found() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.withDraw(1, 2));
    }

    @Test
    void throw_RuntimeException_when_amount_greater_than_balance() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(1, 20, 1)));
        Assertions.assertThrows(RuntimeException.class, () -> accountService.withDraw(1, 22));
    }

    @Test
    void return_updated_account_when_withdraw_amount_less_than_balance() {
        Mockito.when(accountRepository.findById(2)).thenReturn(Optional.of(new Account(2, 50, 2)));
        Account account = accountService.withDraw(2, 30);
        Assertions.assertEquals(account.getBalance(), 20);
    }

    @Test
    void throw_RuntimeException_when_deposit_amount_less_or_equal_to_0() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(1, 50, 1)));
        Assertions.assertThrows(RuntimeException.class, () -> accountService.deposit(1, -2));
    }

    @Test
    void return_updated_account_when_correct_deposit_amount() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(1, 50, 1)));
        Account account = accountService.deposit(1, 20);
        Assertions.assertEquals(account.getBalance(), 70);
    }

    @Test
    void throw_illegalArgumentException_when_deposit_account_is_not_found() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.deposit(1, 2));
    }
}