package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;

import java.util.Optional;

public interface ClientService {
    public Optional<Client> findById(Integer id);
    public Client withDraw(Integer idClient, Integer amount);
    public Client deposit(Integer idClient, Integer amount);
}
