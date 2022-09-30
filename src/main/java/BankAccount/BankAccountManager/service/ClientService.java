package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;

import java.util.Optional;

public interface ClientService {
    public Optional<Client> findById(Integer id);
    public boolean withDraw(Integer amount);
}
