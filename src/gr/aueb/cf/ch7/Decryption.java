package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Decrypt a string (given by user), replacing every character
 * with the previous one (according to ASCII).
 *
 * @author Thodoris
 */
public class Decryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder decrypted = new StringBuilder();

        System.out.print("Please insert the encrypted text: ");
        String encrypted = sc.nextLine();
        for (char letter : encrypted.toCharArray()) {
            letter = (char) (letter - 1);
            decrypted.append(letter);
        }
        System.out.printf("The decrypted text of \"%s\" is: %s", encrypted, decrypted);
    }
}
