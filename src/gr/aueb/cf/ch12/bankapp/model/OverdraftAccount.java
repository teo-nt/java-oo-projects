package gr.aueb.cf.ch12.bankapp.model;

/**
 * Bank account that allows to withdraw amount of money
 * larger than balance.
 */
public class OverdraftAccount {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public OverdraftAccount() {

    }

    public OverdraftAccount(int id, String iban, String firstname, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
     * Public API - Business Services
     */

    /**
     * Returns account's state.
     *
     * @return
     *      account's state.
     */
    public String accountToString() {
        return "(" + id + "," + iban + "," + firstname + "," + lastname + ","
                + ssn + "," + balance + ")";
    }

    /**
     * Withdraws a certain amount of money based on a valid ssn.
     *
     * @param amount
     *      the amount of money to be withdrawn.
     * @param ssn
     *      the given ssn.
     * @throws Exception
     *      if the ssn is not valid or the amount is negative;
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Bad ssn");
            }
            if (amount < 0) {
                throw new Exception("Negative amount error.");
            }
            balance -= amount;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Deposits a certain amount of money in
     * the account.
     *
     * @param amount
     *      the amount to be deposited.
     * @throws Exception
     *      if the amount of money is negative.
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount < 0) {
                throw new Exception("Negative amount error");
            }
            balance += amount;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Checks if ssn provided is valid.
     *
     * @param ssn   the input ssn.
     * @return      true, if ssn is valid,
     *              false otherwise.
     */
    private boolean isSsnValid(String ssn) {
        return  this.ssn.equals(ssn);
    }

    /**
     * Returns account's balance.
     *
     * @return
     *      account's balance.
     */
    public double getAccountBalance() {
        return getBalance();
    }
}
