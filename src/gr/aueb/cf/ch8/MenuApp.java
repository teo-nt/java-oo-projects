package gr.aueb.cf.ch8;

import java.util.Scanner;

/**
 * Prints a menu to the console and user inserts a
 * choice. User's choice is checked to be valid
 * (integer numbers 1-5).
 *
 * @author Thodoris
 */
public class MenuApp {

    public static void main(String[] args) {
        int choice = 0;

        printMenu();
        while (true) {
            try {
                choice = getChoice();
                if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong choice! Accepted values are 1-5.");
            }
            System.out.print("Enter a new choice: ");
        }
    }

    /**
     * Print a menu to the user.
     */
    public static void printMenu() {
        System.out.println("⎯".repeat(12));
        System.out.println("\tMenu");
        System.out.println("⎯".repeat(12));
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");
        System.out.print("Select one of the above: ");
    }

    /**
     * Get user's choice.
     *
     * @return      user's choice.
     */
    public static int getChoice() {
        int choice = 0;
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    break;
                }
                System.out.print("Wrong input! Please insert an integer number (1-5): ");
                while (sc.nextLine().isBlank()) {

                }
            }
            printChoice(choice);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return choice;
    }

    /**
     * Prints user's choice. If it is not valid (1-5)
     * then Exception is thrown.
     *
     * @param choice        user's choice.
     */
    public static void printChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("You chose \"Create\".");
                break;
            case 2:
                System.out.println("You chose \"Read\".");
                break;
            case 3:
                System.out.println("You chose \"Update\".");
                break;
            case 4:
                System.out.println("You chose \"Delete\".");
                break;
            case 5:
                System.out.println("You chose \"Exit\".");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
