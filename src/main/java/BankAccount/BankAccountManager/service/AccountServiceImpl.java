package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.repository.AccountRepository;
import BankAccount.BankAccountManager.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account withDraw(Integer id, Integer amount) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        int balance = account.getBalance();
        if (balance < amount) {
            throw new RuntimeException();
        }
        int newBalance = balance - amount;
        account.setBalance(newBalance);
        return account;
    }

    @Override
    public Account deposit(Integer id, Integer amount) {
        if (amount <= 0) {
            throw new RuntimeException();
        }
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        int balance = account.getBalance();
        int newBalance = balance + amount;
        account.setBalance(newBalance);
        return account;
    }
}
