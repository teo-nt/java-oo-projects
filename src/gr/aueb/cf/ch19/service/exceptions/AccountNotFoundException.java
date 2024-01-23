package gr.aueb.cf.ch19.service.exceptions;

public class AccountNotFoundException extends Exception {
    private static final long serialVersionUID = 2L;

    public AccountNotFoundException(String iban) {
        super("Account with iban: \"" + iban + "\" was not found.");
    }
}
