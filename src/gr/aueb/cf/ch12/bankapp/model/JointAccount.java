package gr.aueb.cf.ch12.bankapp.model;

/**
 * Bank account that includes two holders.
 */
public class JointAccount {
    private int id;
    private String iban;
    private String firstname1;
    private String lastname1;
    private String firstname2;
    private String lastname2;
    private String ssn1;
    private String ssn2;
    private double balance;

    public JointAccount() {
    }

    public JointAccount(int id, String iban, String firstname1, String lastname1, String firstname2, String lastname2,
                                String ssn1, String ssn2, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname1 = firstname1;
        this.lastname1 = lastname1;
        this.firstname2 = firstname2;
        this.lastname2 = lastname2;
        this.ssn1 = ssn1;
        this.ssn2 = ssn2;
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

    public String getFirstname1() {
        return firstname1;
    }

    public void setFirstname1(String firstname1) {
        this.firstname1 = firstname1;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getSsn1() {
        return ssn1;
    }

    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
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
        return "(" + id + ", " + iban + ", " + firstname1 + ", " + lastname1 + ", " + ssn1
                + ",\n" + firstname2 + ", " + lastname2 + ", "
                + ssn2 + ", " + balance + ")";
    }

    /**
     * Withdraws a certain amount of money based on a valid ssn.
     *
     * @param amount
     *      the amount of money to be withdrawn.
     * @param ssn
     *      the given ssn.
     * @throws Exception
     *      if the ssn is not valid or the amount is negative or amount is larger than balance.
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Bad ssn");
            }
            if (amount > balance) {
                throw new Exception("Insufficient balance error");
            }
            if (amount < 0) {
                throw new Exception("Negative amount error.");
            }
            balance -= amount;
        } catch (Exception e) {
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
        return  this.ssn1.equals(ssn) || this.ssn2.equals(ssn);
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
