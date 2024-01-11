package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * User inserts an int number n and n stars
 * are printed vertically.
 */
public class StarsVerticalN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;

        System.out.print("Please insert an integer number: ");
        inputNumber = sc.nextInt();
        for (int i = 1; i <= inputNumber; i++) {
            System.out.println("*");
        }
    }
}