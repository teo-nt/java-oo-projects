package gr.aueb.cf.ch18.dto;

/**
 * DTO for an account.
 */
public class AccountDTO extends BaseDTO {
    private String iban;
    private UserDTO holder;
    private Double balance;

    public AccountDTO() {

    }

    public AccountDTO(String iban, UserDTO holder, Double balance) {
        this.iban = iban;
        this.holder = new UserDTO(holder);
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserDTO getHolder() {
        return new UserDTO(holder);
    }

    public void setHolder(UserDTO holder) {
        this.holder = new UserDTO(holder);
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
