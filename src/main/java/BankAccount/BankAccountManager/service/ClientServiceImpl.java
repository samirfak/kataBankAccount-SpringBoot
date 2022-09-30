package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.repository.AccountRepository;
import BankAccount.BankAccountManager.repository.ClientRepository;

import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    public ClientServiceImpl(ClientRepository clientRepository, AccountRepository accountRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean withDraw(Integer amount) {
        return false;
    }
}
