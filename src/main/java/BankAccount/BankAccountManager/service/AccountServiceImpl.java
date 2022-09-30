package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.repository.AccountRepository;
import BankAccount.BankAccountManager.model.Account;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }
}
