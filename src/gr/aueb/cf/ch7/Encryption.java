package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Encrypt a string (given by user), replacing every character
 * with the next one (according to ASCII).
 *
 * @author Thodoris
 */
public class Encryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder encrypted = new StringBuilder();

        System.out.print("Please insert the text to be encrypted: ");
        String decrypted = sc.nextLine();
        for (char letter : decrypted.toCharArray()) {
            letter = (char) (letter + 1);
            encrypted.append(letter);
        }
        System.out.printf("The encrypted text of \"%s\" is: %s", decrypted, encrypted);
    }
}
