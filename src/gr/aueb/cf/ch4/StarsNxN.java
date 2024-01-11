package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * User inserts an int number n and
 * stars are printed in n*n format.
 */
public class StarsNxN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;

        System.out.print("Please insert an int number: ");
        inputNumber = sc.nextInt();
        for (int i = 1; i <= inputNumber; i++) {
            for (int j = 1; j <= inputNumber; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}