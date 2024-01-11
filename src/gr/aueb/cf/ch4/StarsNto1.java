package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * User inserts an int number n.
 * 1st line prints n stars, 2nd line (n - 1) stars, ...
 * n-th line 1 star.
 */
public class StarsNto1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;

        System.out.print("Please insert an int number: ");
        inputNumber = sc.nextInt();
        for (int i = inputNumber; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}