package gr.aueb.cf.ch19.dao;

import gr.aueb.cf.ch19.model.Account;
import gr.aueb.cf.ch19.model.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of Account DAO.
 */
public class AccountDAOImpl implements IAccountDAO {
    private static final Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Account insert(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public Account update(String iban, User newUser) {
        Account account = accounts.values().stream()
                        .filter(acc -> acc.getIban().equals(iban))
                        .collect(Collectors.toList()).get(0);
        account.setHolder(newUser);
        return account;
    }

    @Override
    public void delete(String iban) {
        accounts.values().removeIf(acc -> acc.getIban().equals(iban));
    }

    @Override
    public Account get(String iban) {
        Optional<Account> account = accounts.values().stream()
                .filter(acc -> acc.getIban().equals(iban))
                .findFirst();
        return account.orElse(null);
    }

    @Override
    public Map<Long, Account> getAll() {
        return Collections.unmodifiableMap(accounts);
    }

    @Override
    public boolean accountExists(String iban) {
        return accounts.values().stream().anyMatch(acc -> acc.getIban().equals(iban));
    }

    @Override
    public Double getBalance(String iban) {
        Optional<Account> account = accounts.values().stream()
                .filter(acc -> acc.getIban().equals(iban))
                .findFirst();
        return account.get().getBalance();
    }

    @Override
    public void deposit(String iban, Double amount) {
        Account account = accounts.values().stream()
                .filter(acc -> acc.getIban().equals(iban))
                .collect(Collectors.toList()).get(0);
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public Double withdraw(String iban, Double amount) {
        Account account = accounts.values().stream()
                .filter(acc -> acc.getIban().equals(iban))
                .collect(Collectors.toList()).get(0);
        account.setBalance(account.getBalance() - amount);
        return amount;
    }
}
