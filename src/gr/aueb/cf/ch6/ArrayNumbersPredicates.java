package gr.aueb.cf.ch6;

import java.util.Scanner;

/**
 * User inserts 6 numbers from 1 to 49 and
 * the program checks if the set of numbers
 * passes some conditions.
 *
 * @author Thodoris
 */
public class ArrayNumbersPredicates {
    static int[] arr = new int[6];
    static final int THRESHOLD = 3;

    public static void main(String[] args) {
        userInput();
        printArr();
        System.out.println("1. Does not contain more than 3 even numbers: " + !evenCounter());
        System.out.println("2. Does not contain more than 3 odd numbers: " + !oddCounter());
        System.out.println("3. Does not contain more than 3 consecutive numbers: " + !countConsecutive());
        System.out.println("4. Does not contain more than 3 numbers with the same ending: " + !countNumEndings());
        System.out.println("5. Does not contain more than 3 numbers in the same decade: " + !countNumDecade());
    }

    /**
     * Print the numbers of the array.
     */
    public static void printArr() {
        System.out.println("*".repeat(45));
        System.out.print("\tInserted numbers: " + "[ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]\n");
        System.out.println("*".repeat(45));
    }

    /**
     * Program prompts user to enter 6 numbers (1 - 49)
     * and the array is populated.
     */
    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert 6 numbers (1 - 49 are valid numbers!):");

        for (int i = 0; i < arr.length; i++) {
            while (true) {
                System.out.print("Insert number " + (i + 1) + ": ");
                arr[i] = sc.nextInt();
                if (arr[i] >= 1 && arr[i] <= 49) {
                    break;
                }
                System.out.println("Wrong input. Only 1-49 are valid numbers!");
            }
        }
        System.out.println();
    }

    /**
     * Returns true if the array has more
     * than 3 even numbers.
     *
     * @return      true if even numbers exceed threshold.
     */
    public static boolean evenCounter() {
        int evens = 0;
        for (int num : arr) {
            evens += (num % 2 == 0) ? 1 : 0;
        }
        return evens > THRESHOLD;
    }

    /**
     * Returns true if the array has more
     * than 3 odd numbers.
     *
     * @return      true if odd numbers exceed threshold.
     */
    public static boolean oddCounter() {
        int odds = 0;
        for (int num : arr) {
            odds += (num % 2 == 1) ? 1 : 0;
        }
        return odds > THRESHOLD;
    }

    /**
     * Count consecutive numbers in the array.
     *
     * @return      true, if consecutive numbers are more than 3 (threshold),
     *              false otherwise.
     */
    public static boolean countConsecutive() {
        int counter = 0;
        for (int i = 0; i < arr.length - THRESHOLD; i++) {
            if (arr[i] == arr[i+1] - 1 && arr[i] == arr[i+2] - 2 && arr[i] == arr[i+3] - 3) {
                counter++;
            }
        }
        return counter >= 1;
    }

    /**
     * Count numbers in the array with the same ending number.
     *
     * @return      true, if there are more than 3 (threshold) numbers
     *              with the same ending, false otherwise.
     */
    public static boolean countNumEndings() {
        int[] endings = new int[10];
        for (int num : arr) {
            endings[num % 10]++;
        }
        for (int num : endings) {
            if (num > THRESHOLD) {
                return true;
            }
        }
        return false;
    }

    /**
     * Count the numbers belonging to the same decade.
     *
     * @return      true, if there are more than 3 numbers
     *              in the same decade, false otherwise.
     */
    public static boolean countNumDecade() {
        int[] decades = new int[5];
        for (int num : arr) {
            decades[num / 10]++;
        }
        for (int num : decades) {
            if (num > THRESHOLD) {
                return true;
            }
        }
        return false;
    }
}
