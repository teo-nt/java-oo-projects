package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * User inserts day, month, year as integers and it
 * is displayed in DD/MM/YY format.
 *
 * @author Thodoris
 */
public class DateApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = 0, month = 0, year = 0;

        System.out.println("Please insert day, month and year as integers (in this order):");
        day = sc.nextInt();
        month = sc.nextInt();
        year = sc.nextInt();
        year = year % 100;

        System.out.printf("Formatted date is %02d/%02d/%02d", day, month, year);
    }
}
