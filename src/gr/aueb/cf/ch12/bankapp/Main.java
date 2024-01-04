package gr.aueb.cf.ch12.bankapp;

import gr.aueb.cf.ch12.bankapp.model.JointAccount;
import gr.aueb.cf.ch12.bankapp.model.OverdraftAccount;

/**
 * Creates instances of {@link gr.aueb.cf.ch12.bankapp.model.OverdraftAccount} and
 * {@link gr.aueb.cf.ch12.bankapp.model.JointAccount} classes and checks their methods.
 *
 * @author Thodoris
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        OverdraftAccount overAccount = new OverdraftAccount(1, "GR123", "George", "K.",
                                                                "11223", 1000.0);
        JointAccount jointAccount = new JointAccount(2, "GR987", "John", "P.",
                                        "Maria", "N.", "33445", "77889", 5000.0);

        try {
            overAccount.deposit(500);
            overAccount.withdraw(2000, "11223");

            // Overdraft account has now negative balance
            System.out.println("Overdraft account balance: " + overAccount.getAccountBalance());

            System.out.println(jointAccount.accountToString());
            jointAccount.withdraw(3000, "33445");
            jointAccount.withdraw(1000, "77889");
            System.out.println("Joint account balance: " + jointAccount.getBalance());

            // Wrong ssn throws exception
            jointAccount.withdraw(500, "12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
