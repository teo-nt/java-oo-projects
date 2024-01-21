package gr.aueb.cf.ch18.service.exceptions;

public class SsnNotValidException extends Exception {
    private static final long serialVersionUID = 5L;

    public SsnNotValidException(String ssn) {
        super("Ssn: \"" + ssn + "\" is not valid for this account");
    }
}
