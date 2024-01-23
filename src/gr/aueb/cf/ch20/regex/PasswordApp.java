package gr.aueb.cf.ch20.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Requests a password from user and checks
 * if it is valid. A valid password has the following form:
 * -at least 8 characters.
 * -at least 1 lowercase letter.
 * -at least 1 uppercase letter.
 * -at least 1 number.
 * -at least 1 special character (#?!@$%^&*-).
 *
 * @author Thodoris
 */
public class PasswordApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = "";

        System.out.print("Please insert a password: ");
        password = sc.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        Matcher matcher = pattern.matcher(password);

        System.out.println(matcher.matches() ? "Valid password" : "Not valid password.");
    }
}
