package gr.aueb.cf.ch18.model;

/**
 * Represents a bank account.
 */
public class Account extends AbstractEntity {
    private String iban;
    private User holder;
    private Double balance;

    public Account() {

    }

    public Account(String iban, User holder, Double balance) {
        this.iban = iban;
        this.holder = new User(holder);
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getHolder() {
        return new User(holder);
    }

    public void setHolder(User holder) {
        this.holder = new User(holder);
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", holder=" + holder +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        if (!iban.equals(account.iban)) return false;
        if (!holder.equals(account.holder)) return false;
        return balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + iban.hashCode();
        result = 31 * result + holder.hashCode();
        result = 31 * result + balance.hashCode();
        return result;
    }
}
