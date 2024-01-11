package gr.aueb.cf.ch10.project03;

import java.util.Arrays;

/**
 * Demonstrates the difference between shallow copy and
 * deep copy of 2D arrays.
 *
 * @author Thodoris
 */
public class ArrayCopyApp {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        int[][] shallowCopyArr = shallowCopy(arr);

        // Shallow copy
        shallowCopyArr[2][2] = 10;
        shallowCopyArr[0][0] = 0;
        System.out.println("Shallow Copy");
        System.out.println("Copied array after edit:");
        printArr(shallowCopyArr);
        System.out.println("Original array after edit of shallow copy array:");
        printArr(arr);

        int[][] deepCopyArr = deepCopy(arr);
        // Deep copy
        deepCopyArr[0][0] = 5;
        deepCopyArr[2][2] = 12;
        System.out.println("Deep Copy");
        System.out.println("Copied array after edit:");
        printArr(deepCopyArr);
        System.out.println("Original array after edit of deep copy array:");
        printArr(arr);
    }

    /**
     * The initial array is shallow copied (the references are copied).
     *
     * @param arr   the input 2D array.
     * @return      the copied array.
     */
    public static int[][] shallowCopy(int[][] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    /**
     * The initial array is deeply copied.
     *
     * @param arr   the input 2D array.
     * @return      the copied array.
     */
    public static int[][] deepCopy(int[][] arr) {
        int[][] deepCopyArr = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            deepCopyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return deepCopyArr;
    }

    /**
     * Prints to the console the 2D array.
     *
     * @param arr       the input 2D array.
     */
    public static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
