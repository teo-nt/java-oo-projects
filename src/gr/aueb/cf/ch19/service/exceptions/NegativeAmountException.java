package gr.aueb.cf.ch19.service.exceptions;

public class NegativeAmountException extends Exception {
    private static final long serialVersionUID = 4L;

    public NegativeAmountException() {
        super("Negative amount is not allowed.");
    }
}
