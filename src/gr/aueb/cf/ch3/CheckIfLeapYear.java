package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Program asks user to enter a year from stdin
 * and it decides if it is a leap year.
 * The result is printed to the console.
 *
 * @author Thodoris
 */
public class CheckIfLeapYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputYear = 0;

        System.out.print("Please insert a year: ");
        inputYear = sc.nextInt();
        if (inputYear > 0) {
            if (inputYear % 400 == 0 || (inputYear % 4 == 0 && inputYear % 100 != 0)) {
                System.out.println(inputYear + " is a leap year!");
            } else {
                System.out.println(inputYear + " is not a leap year!");
            }
        } else {
            System.out.println("Wrong input!");
        }
    }
}
