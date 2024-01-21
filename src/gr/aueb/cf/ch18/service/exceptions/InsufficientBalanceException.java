package gr.aueb.cf.ch18.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 3L;

    public InsufficientBalanceException() {
        super("Balance is not sufficient to perform this transaction.");
    }
}
