package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;

import java.util.Optional;

public interface AccountService {
    public Optional<Account> findById(Integer id);
    public Account withDraw(Integer id, Integer amount);
    public Account deposit(Integer id, Integer amount);
}
