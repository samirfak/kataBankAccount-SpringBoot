package BankAccount.BankAccountManager.service;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import BankAccount.BankAccountManager.repository.AccountRepository;
import BankAccount.BankAccountManager.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public ClientServiceImpl(ClientRepository clientRepository, AccountRepository accountRepository, AccountService accountService) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client withDraw(Integer idClient, Integer amount) {
        Client client = clientRepository.findById(idClient).orElseThrow(IllegalArgumentException::new);
        Account account = accountService.withDraw(client.getAccount().getId(), amount) ;
        return clientRepository.findByAccount(account);
    }

    @Override
    public Client deposit(Integer idClient, Integer amount) {
        Client client = clientRepository.findById(idClient).orElseThrow(IllegalArgumentException::new);
        Account account = accountService.deposit(client.getAccount().getId(), amount) ;
        return clientRepository.findByAccount(account);
    }
}
