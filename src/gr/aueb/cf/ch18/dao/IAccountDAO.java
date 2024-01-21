package gr.aueb.cf.ch18.dao;

import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.model.User;

import java.util.List;

public interface IAccountDAO {
    /**
     * Insert a new account in the data source.
     *
     * @param account   the account to be added.
     * @return          the account inserted.
     */
    Account insert(Account account);

    /**
     * Update an existing account with a new user.
     *
     * @param iban      the iban of the account.
     * @param newUser   the new user of account.
     * @return          the new account.
     */
    Account update(String iban, User newUser);

    /**
     * Delete an account.
     *
     * @param iban      the iban of account to be deleted.
     */
    void delete(String iban);

    /**
     * Get a specific account.
     *
     * @param iban      the iban of wanted account.
     * @return          the account.
     */
    Account get(String iban);

    /**
     * Get all accounts contained in data source.
     *
     * @return      a list of all accounts.
     */
    List<Account> getAll();

    /**
     * Checks if a specific account exists in the data source.
     *
     * @param iban      account's iban.
     * @return          true, if an account exists with the requested iban.
     */
    boolean accountExists(String iban);

    /**
     * Get the balance of an account.
     *
     * @param iban      iban of account.
     * @return          balance of account.
     */
    Double getBalance(String iban);

    /**
     * Deposit money to an account.
     *
     * @param iban      iban of account.
     * @param amount    amount to be deposited.
     */
    void deposit(String iban, Double amount);

    /**
     * Withdraw money from an account.
     *
     * @param iban      iban of account.
     * @param amount    amount to be withdrawn.
     * @return          amount withdrawn.
     */
    Double withdraw(String iban, Double amount);
}
