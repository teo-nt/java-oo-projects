package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * User inserts an int number n.
 * 1st line prints 1 star, 2nd 2 stars, ... n-th line
 * n stars.
 */
public class Stars1toN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;

        System.out.print("Please insert an int number: ");
        inputNumber = sc.nextInt();
        for (int i = 1; i <= inputNumber; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
