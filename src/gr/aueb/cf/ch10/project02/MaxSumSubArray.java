package gr.aueb.cf.ch10.project02;

import java.util.Arrays;

/**
 * Calculate the maximum sum of subarray of a given array (O(n) time complexity).
 *
 * @author Thodoris
 */
public class MaxSumSubArray {
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubSum(arr);
        System.out.printf("Maximum sum subarray of %s is: %d", Arrays.toString(arr), maxSum);
    }

    public static void maxSubSum(int[] arr) {
        int currentSum = arr[0];
        maxSum = currentSum;
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
    }
}
