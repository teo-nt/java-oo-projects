package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * User inserts Fahrenheit, it is converted to Celsius and
 * it is printed to the console.
 *
 * @author Thodoris
 */
public class ConvertFahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fahrenheit = 0;
        int celsius = 0;

        System.out.println("Please insert temperature in Fahrenheit");
        fahrenheit = sc.nextInt();

        celsius = 5 * (fahrenheit - 32) / 9;

        System.out.printf("%d Fahrenheit is %d Celsius", fahrenheit, celsius);
    }
}
