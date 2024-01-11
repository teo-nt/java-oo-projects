package gr.aueb.cf.ch6;

import java.util.Scanner;

/**
 * User inserts the number of cars that parked and times of arrival
 * and departure of each car.
 * App calculates the maximum number of cars that parked at the same time
 * and prints it to the console.
 *
 * @author Thodoris
 */
public class MaxParkedCars {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = readArrivalDeparture();    //{{1012, 1136},{1317, 1417},{1015, 1020}};
        int[][] assistArr = fillArray(arr);
        assistArr = sortArray(assistArr);

        /*for (int[] row : assistArr) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }*/

        System.out.println("Max parked cars at the same time: " + maxParkedCars(assistArr));
    }

    /**
     * Fill an assisting 2d array with times in first column and 0 or 1 in the second column
     * (0: time indicates departure, 1: time indicates arrival).
     *
     * @param arr
     *                  the array containing times of arrival and departure.
     * @return
     *                  2d array with times in first column and 0 or 1 in the second column.
     */
    public static int[][] fillArray(int[][] arr) {
        int[][] assistArr = new int[arr.length * 2][2];
        for (int i = 0, j = 0; i < assistArr.length; i++) {
            assistArr[i][0] = arr[i / 2][j];
            assistArr[i][1] = (j == 0) ? 1 : 0;
            j = (j == 0) ? 1 : 0;
        }
        return assistArr;
    }

    /**
     * Sort the assisting array according to times.
     *
     * @param assistArr         the 2d array to be sorted.
     * @return                  sorted array (times ascending).
     */
    public static int[][] sortArray(int[][] assistArr) {
        int min;
        int minPosition;
        int[] tmp;

        for (int i = 0; i < assistArr.length - 1; i++) {
            min = assistArr[i][0];
            minPosition = i;
            for (int j = i + 1; j < assistArr.length; j++) {
                if (assistArr[j][0] < min) {
                    min = assistArr[j][0];
                    minPosition = j;
                }
            }
            tmp = assistArr[i];
            assistArr[i] = assistArr[minPosition];
            assistArr[minPosition] = tmp;
        }
        return assistArr;
    }

    /**
     * User inserts the total number of cars and arrival and departure time
     * for each one (program exits if user inserts number of cars <= 0).
     *
     * @return      2d array containing arrival and departure time of each car.
     */
    public static int[][] readArrivalDeparture() {
        int[][] arr;
        int num = 0;

        System.out.print("Please insert the total number of cars (<=0 to exit): ");
        num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Goodbye...");
            System.exit(1);
        }
        arr = new int[num][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) System.out.printf("Insert arrival time for car %d: ", i + 1);
                if (j == 1) System.out.printf("Insert departure time for car %d: ", i + 1);
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    /**
     * Calculates the maximum number of cars that parked at the same time.
     *
     * @param arr       assisting array.
     * @return          the maximum number of cars.
     */
    public static int maxParkedCars(int[][] arr) {
        int maxCars = 0;
        int parkedCars = 0;
        for (int[] row : arr) {
            parkedCars += (row[1] == 1) ? 1 : -1;
            if (parkedCars > maxCars) {
                maxCars = parkedCars;
            }
        }
        return maxCars;
    }
}
