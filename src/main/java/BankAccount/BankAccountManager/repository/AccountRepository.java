package BankAccount.BankAccountManager.repository;

import BankAccount.BankAccountManager.model.Account;
import BankAccount.BankAccountManager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {
    public Optional<Account> findById(Integer id);
}
