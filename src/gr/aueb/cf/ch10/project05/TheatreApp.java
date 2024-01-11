package gr.aueb.cf.ch10.project05;

import java.util.Scanner;

/**
 * Manages a theatre with 30 rows and 12 columns (360 total seats) by booking or
 * cancelling a seat. Each seat is described by a character (column) and a number (row).
 *
 * @author Thodoris
 */
public class TheatreApp {

    static Scanner sc = new Scanner(System.in);
    static boolean[][] theatre = new boolean[30][12];   // already initialized with all positions as false (not booked seats).

    public static void main(String[] args) {
        int choice = 0;
        int row = 0;
        char column;

        System.out.println("Welcome to the theatre seat booking application!");

        while (true) {
            printMenu();
            choice = getUserChoice();
            if (choice == 3) {
                System.out.println("Thank you for using the application! Goodbye...");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Choose the seat you would like to book");
                    column = getColumn();
                    System.out.printf("You chose column: %s.%n", column);
                    row = getRow();
                    System.out.printf("You chose row: %d.%n", row);
                    if (isBooked(column, row)) {
                        System.out.printf("The seat %s%d is already booked!%n", column, row);
                        continue;
                    }
                    book(column, row);
                    System.out.printf("You have successfully booked %s%d seat.%n", column, row);
                    break;
                case 2:
                    System.out.println("Choose the seat you would like to cancel");
                    column = getColumn();
                    System.out.printf("You chose column: %s.%n", column);
                    row = getRow();
                    System.out.printf("You chose row: %d.%n", row);
                    if (!isBooked(column, row)) {
                        System.out.printf("The seat %s%d is not booked to be able to cancel.%n", column, row);
                        continue;
                    }
                    cancel(column, row);
                    System.out.printf("You have successfully cancelled %s%d seat%n", column, row);
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }

    /**
     * Print the initial menu of the app.
     */
    public static void printMenu() {
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a seat");
        System.out.println("3. Quit");
        System.out.print("Choose one of the above: ");
    }

    /**
     * Get a valid user choice from the menu.
     *
     * @return      valid user's choice (integer number 1-3).
     */
    public static int getUserChoice() {
        int choice = 0;
        while (true) {
            try {
                while (!sc.hasNextInt()) {
                    System.out.print("Wrong choice. Numbers 1 - 3 are acceptable values. Insert a new choice: ");
                    sc.next();
                    sc.nextLine();
                }
                choice = sc.nextInt();
                sc.nextLine();
                if (choice < 1 || choice > 3) {
                    throw new Exception("Wrong number. Please insert a number with values 1-3: ");
                }
                return choice;
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    /**
     * Get a valid column (A - L).
     *
     * @return      the valid column.
     */
    public static char getColumn() {
        System.out.print("Choose the column (A - L): ");
        String column = "";
        while (true) {
            column = sc.next();
            char firstLetter = column.toUpperCase().charAt(0);
            sc.nextLine();
            if (column.length() != 1 || firstLetter < 65 || firstLetter > 76) {      // 65-76 are valid ordinal numbers for A-L columns.
                System.out.print("Wrong choice! Insert a valid column (A - L): ");
                continue;
            }
            return firstLetter;
        }
    }

    /**
     * Get a valid row (1 - 30).
     *
     * @return      the valid row.
     */
    public static int getRow() {
        int row = 0;
        System.out.print("Choose the row (1 - 30): ");
        while (true) {
            try {
                while (!sc.hasNextInt()) {
                    System.out.print("Only numbers 1 - 30 are acceptable values. Insert a new choice: ");
                    sc.next();
                    sc.nextLine();
                }
                row = sc.nextInt();
                sc.nextLine();
                if (row < 1 || row > 30) {
                    throw new Exception("Wrong row number. Please insert a number with values 1-30: ");
                }
                return row;
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    /**
     * Checks if the seat defined by column and row is booked.
     *
     * @param column    the column of the seat.
     * @param row       the row of the seat.
     * @return          true, if the seat is already booked,
     *                  false otherwise.
     */
    public static boolean isBooked(char column, int row) {
        return theatre[row - 1][column - 65];       // e.g. column = A, row = 1, then this seat is theatre[0][0]
    }

    /**
     * Book a seat in the theatre.
     *
     * @param column        the column of the seat.
     * @param row           the row of the seat.
     */
    public static void book(char column, int row) {
        theatre[row - 1][column - 65] = true;
    }

    /**
     * Cancel a booking.
     *
     * @param column        the column of the seat.
     * @param row           the row of the seat.
     */
    public static void cancel(char column, int row) {
        theatre[row - 1][column - 65] = false;
    }
}