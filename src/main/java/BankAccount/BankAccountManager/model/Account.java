package BankAccount.BankAccountManager.model;

import javax.persistence.Id;

public class Account {
    @Id
    private int id;
    private int balance ;

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
