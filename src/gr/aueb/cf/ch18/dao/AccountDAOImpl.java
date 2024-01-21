package gr.aueb.cf.ch18.dao;

import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of Account DAO.
 */
public class AccountDAOImpl implements IAccountDAO {
    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public User update(String iban, User newUser) {
        Account oldAccount = accounts.stream()
                        .filter(acc -> acc.getIban().equals(iban))
                        .collect(Collectors.toList()).get(0);
        Account newAccount = new Account(iban, newUser, oldAccount.getBalance());
        accounts.set(accounts.indexOf(oldAccount), newAccount);
        return newUser;
    }

    @Override
    public void delete(String iban) {
        accounts.removeIf(acc -> acc.getIban().equals(iban));
    }

    @Override
    public Account get(String iban) {
        Optional<Account> account = accounts.stream()
                .filter(acc -> acc.getIban().equals(iban))
                .findFirst();
        return account.orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public boolean accountExists(String iban) {
        return accounts.stream().anyMatch(acc -> acc.getIban().equals(iban));
    }

    @Override
    public Double getBalance(String iban) {
        Optional<Account> account = accounts.stream()
                .filter(acc -> acc.getIban().equals(iban))
                .findFirst();
        return account.get().getBalance();
    }

    @Override
    public void deposit(String iban, Double amount) {
        Account account = accounts.stream()
                .filter(acc -> acc.getIban().equals(iban))
                .collect(Collectors.toList()).get(0);
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public Double withdraw(String iban, Double amount) {
        Account account = accounts.stream()
                .filter(acc -> acc.getIban().equals(iban))
                .collect(Collectors.toList()).get(0);
        account.setBalance(account.getBalance() - amount);
        return amount;
    }
}
