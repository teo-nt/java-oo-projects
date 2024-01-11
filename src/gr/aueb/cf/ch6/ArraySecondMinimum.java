package gr.aueb.cf.ch6;

/**
 * Finds the second minimum number in
 * an array (which is bigger than the minimum
 * of that array). Array content is generated
 * randomly.
 *
 * @author Thodoris
 */
public class ArraySecondMinimum {

    public static void main(String[] args) {
        final int LENGTH = 10;
        int[] arr = new int[LENGTH];
        int secondMin = 0;

        // Populate the array with random numbers between 0 and 100.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        secondMin = secondMinValue(arr);
        if (secondMin != Integer.MAX_VALUE) {
            System.out.println("\nSecond minimum number in the array is: " + secondMin);
        } else {
            System.out.println("\nArray is null or has insufficient numbers or all numbers are equal.");
        }
    }

    /**
     * Returns the second minimum number of the array.
     *
     * @param arr       the source array.
     * @return          the second minimum number of the array.
     */
    public static int secondMinValue(int[] arr) {
        if (arr == null) return Integer.MAX_VALUE;
        if (arr.length < 2) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;       // the minimum number.
        int min2 = Integer.MAX_VALUE;      // the second minimum number.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min2 = min;
                min = arr[i];
                continue;
            }
            if (arr[i] < min2 && arr[i] != min) {
                min2 = arr[i];
            }
        }
        return min2;
    }
}
