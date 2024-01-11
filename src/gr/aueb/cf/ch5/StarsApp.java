package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * App displays stars with 5 different ways:
 *  1) n horizontal stars
 *  2) n vertical stars
 *  3) n x n stars
 *  4) n x lines having stars 1 - n
 *  5) n x lines having stars n - 1
 * User inserts choice and the n number.
 *
 * @author Thodoris
 */
public class StarsApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int numOfStars = 0;

        while (true) {
            printMenu();
            choice = sc.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Λάθος επιλογή!");
                continue;
            }
            if (choice == 6) {
                System.out.println("Έξοδος...\nΕυχαριστούμε που χρησιμοποιήσατε την εφαρμογή!");
                break;
            }
            System.out.println("Δώστε αριθμό για αστεράκια");
            numOfStars = sc.nextInt();
            switch (choice) {
                case 1:
                    printHorizontalStars(numOfStars);
                    break;
                case 2:
                    printVerticalStars(numOfStars);
                    break;
                case 3:
                    printNxNStars(numOfStars);
                    break;
                case 4:
                    printStars1toN(numOfStars);
                    break;
                case 5:
                    printStarsNto1(numOfStars);
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Εμφάνισε n αστεράκια οριζόντια\n" +
                "2. Εμφάνισε n αστεράκια κάθετα\n"+
                "3. Εμφάνισε n γραμμές με n αστεράκια\n"+
                "4. Εμφάνισε n γραμμές με αστεράκια 1 – n\n"+
                "5. Εμφάνισε n γραμμές με αστεράκια n – 1\n"+
                "6. Έξοδος από το πρόγραμμα\n"+
                "Δώσε επιλογή: ");
    }

    public static void printHorizontalStars(int numOfStars) {
        for (int i = 1; i <= numOfStars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void printVerticalStars(int numOfStars) {
        for (int i = 1; i <= numOfStars; i++) {
            System.out.println("*");
        }
    }

    public static void printNxNStars(int numOfStars) {
        for (int i = 1; i <= numOfStars; i++) {
            printHorizontalStars(numOfStars);
        }
    }

    public static void printStars1toN(int numOfStars) {
        for (int i = 1; i <= numOfStars; i++) {
            printHorizontalStars(i);
        }
    }

    public static void printStarsNto1(int numOfStars) {
        for (int i = numOfStars; i >= 1; i--) {
            printHorizontalStars(i);
        }
    }
}
