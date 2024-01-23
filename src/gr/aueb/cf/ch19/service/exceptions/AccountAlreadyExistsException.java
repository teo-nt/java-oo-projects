package gr.aueb.cf.ch19.service.exceptions;

import gr.aueb.cf.ch19.model.Account;

public class AccountAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    public AccountAlreadyExistsException(Account account) {
        super("Account with iban: \"" + account.getIban() + "\" already exists.");
    }
}
