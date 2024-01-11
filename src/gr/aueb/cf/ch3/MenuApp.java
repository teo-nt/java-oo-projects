package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Prints repetitively a menu with
 * choices 1-5. Choices 1-4 print feedback
 * to the user. Choice 5 terminates the program.
 * If wrong input is entered, a message is displayed.
 *
 * @author Thodoris
 */
public class MenuApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("Επιλέξτε μία από τις παρακάτω επιλογές:\n" +
                               "1. Εισαγωγή\n" +
                               "2. Διαγραφή\n" +
                               "3. Ενημέρωση\n" +
                               "4. Αναζήτηση\n" +
                               "5. Έξοδος");
            choice = sc.nextInt();
            if (choice <= 0 || choice > 5) {
                System.out.println("Λάθος αριθμός. Έγκυροι αριθμοί: 1-5!");
                continue;
            }
            if (choice == 1) {
                System.out.println("Επιλέξατε Εισαγωγή");
                continue;
            }
            if (choice == 2) {
                System.out.println("Επιλέξατε Διαγραφή");
                continue;
            }
            if (choice == 3) {
                System.out.println("Επιλέξατε Ενημέρωση");
                continue;
            }
            if (choice == 4) {
                System.out.println("Επιλέξατε Αναζήτηση");
                continue;
            }
            System.out.println("Επιλέξατε έξοδο.");
            break;
        }
        System.out.println("Ευχαριστούμε που χρησιμοποιήσατε το πρόγραμμα!");
    }
}
