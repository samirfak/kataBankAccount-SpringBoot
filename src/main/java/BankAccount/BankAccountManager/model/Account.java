package BankAccount.BankAccountManager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Account {
    @Id
    private int id;
    private int balance ;
    private int idClient;

    public Account(int id, int balance, int idClient) {
        this.id = id;
        this.balance = balance;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }
}
