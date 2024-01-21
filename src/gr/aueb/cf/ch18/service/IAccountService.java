package gr.aueb.cf.ch18.service;

import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.dto.UserDTO;
import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.service.exceptions.*;

import java.util.List;

public interface IAccountService {
    /**
     * Insert a new account in the data source.
     *
     * @param accountDTO    the account to be inserted.
     * @return              the account inserted.
     * @throws AccountAlreadyExistsException
     *      if the account already exists.
     */
    Account insertAccount(AccountDTO accountDTO)
        throws AccountAlreadyExistsException;

    /**
     * Updates an account with a new user.
     *
     * @param iban      the iban of the account to be modified.
     * @param userDTO   the new holder of the account.
     * @return          the new account.
     * @throws AccountNotFoundException
     *      if the requested account does not exist.
     */
    Account updateAccount(String iban, UserDTO userDTO)
        throws AccountNotFoundException;

    /**
     * Delete an account by iban.
     *
     * @param iban      account's iban to be deleted.
     * @throws AccountNotFoundException
     *      if the account does not exist.
     */
    void deleteAccountByIban(String iban)
        throws AccountNotFoundException;

    /**
     * Gets an account by iban.
     *
     * @param iban      iban of wanted account.
     * @return          the account.
     * @throws AccountNotFoundException
     *      if the account with this iban does not exist.
     */
    Account getByIban(String iban)
        throws AccountNotFoundException;

    /**
     * Gets all accounts.
     *
     * @return      a list of accounts contained in data source.
     */
    List<Account> getAllAccounts();

    /**
     * Returns the balance of an account.
     *
     * @param iban      iban of requested account.
     * @param ssn       ssn of the holder of the account.
     * @return          account's balance.
     * @throws AccountNotFoundException
     *      if the account with this iban does not exist.
     * @throws SsnNotValidException
     *      if the ssn inserted does not match with that of holder's ssn.
     */
    Double getBalanceByIban(String iban, String ssn)
        throws AccountNotFoundException, SsnNotValidException;

    /**
     * Deposits an amount of money in the account.
     *
     * @param iban      iban of account
     * @param amount    amount to be deposited.
     * @throws AccountNotFoundException
     *      if the account with the given iban does not exist.
     * @throws NegativeAmountException
     *      if the amount inserted is negative.
     */
    void depositToIban(String iban, Double amount)
        throws AccountNotFoundException, NegativeAmountException;

    /**
     * Withdraw money from an account.
     *
     * @param iban      iban of account.
     * @param amount    amount to be withdrawn.
     * @param ssn       ssn of account's holder.
     * @return          amount withdrawn.
     * @throws AccountNotFoundException
     *      if the inserted iban does not match with any account.
     * @throws InsufficientBalanceException
     *      if the amount is larger than account's balance.
     * @throws NegativeAmountException
     *      if the amount is negative.
     * @throws SsnNotValidException
     *      if the inserted ssn does not match with that of account's holder's one.
     */
    Double withdraw(String iban, Double amount, String ssn)
        throws AccountNotFoundException, InsufficientBalanceException, NegativeAmountException, SsnNotValidException;
}
