package gr.aueb.cf.ch6;

/**
 * Finds the position of maximum number
 * in an array.
 *
 * @author Thodoris
 */
public class GetMaxPosition {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 8, 54, 32, 43, 56, 3};
        int maxPosition = 0;

        maxPosition = getMaxPosition(arr, 0, arr.length - 1);
        if (maxPosition != -1) {
            System.out.printf("Position of maximum number in the array is: %d", maxPosition + 1);
        } else {
            System.out.println("Wrong input or array is null");
        }
    }

    /**
     * Returns position of the maximum number in an array.
     *
     * @param arr       the source array.
     * @param low       the starting index of array.
     * @param high      the last index of array.
     * @return          position of maximum number in the array.
     */
    public static int getMaxPosition(int[] arr, int low, int high) {
        if (arr == null) return -1;
        if (low < 0 || high > arr.length - 1) return -1;
        if (high < low) return -1;
        int maxPosition = low;
        int max = arr[low];
        for (int i = low; i <= high; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }
}
