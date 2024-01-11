package gr.aueb.cf.ch6;

import java.util.Arrays;

/**
 * Find the low and high index of a sorted array for
 * a number, if it exists in the array.
 *
 * @author Thodoris
 */
public class LowAndHighIndex {

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};
        int key = 8;
        int[] indexArr = getLowAndHighIndexOf(arr, key);

        if (indexArr[0] == -1) {
            System.out.println("Key was not found in the array or array is null!");
        } else {
            System.out.println("Low and high index of " + key + " are: " + Arrays.toString(indexArr));
        }
    }

    /**
     * Calculate the low and high index of a sorted array for
     * a number if it exists in the array.
     *
     * @param arr       the sorted array.
     * @param key       the number to be found.
     * @return          an array with low and high index.
     */
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        if (arr == null) return new int[] {-1, -1};
        int low = -1;
        int high = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                low = (low == -1) ? i : low;
                high = i;
            }
        }
        return new int[] {low, high};
    }
}
