package gr.aueb.cf.ch10.project01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads integer numbers from a file  (containing at least 6 numbers with value: 1-49).
 * Then, combinations of 6 numbers are calculated and if they pass some criteria,
 * they are printed to another .txt file.
 *
 * @author Thodoris
 */
public class NumbersCombinationsApp {

    public static void main(String[] args) {
        String line = "";
        ArrayList<String> numbers = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\project01\\numbers.txt", StandardCharsets.UTF_8))) {

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                numbers.addAll(List.of(line.trim().split(" +")));
            }
            if (numbers.size() < 7 || numbers.size() > 49) {
                System.out.println("Input file does not contain 7-49 total numbers.");
                System.exit(1);
            }
            int[] numbersArr = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                numbersArr[i] = Integer.parseInt(numbers.get(i));
            }
            Arrays.sort(numbersArr);
            produceNumberCombinations(numbersArr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calculate the possible combinations of 6 numbers from the array and print them to the
     * combinations.txt file if they pass some filters.
     *
     * @param numberArr     the input array of total integer numbers.
     */
    public static void produceNumberCombinations(int[] numberArr) throws FileNotFoundException {
        int m = 6;          // combination of 6 numbers
        int[] row = new int[m];

        try (PrintStream ps = new PrintStream(new FileOutputStream("C:\\tmp\\project01\\combinations.txt"), true, StandardCharsets.UTF_8)) {

            for (int i = 0; i <= numberArr.length - m; i++) {
                for (int j = i + 1; j <= numberArr.length - m + 1; j++) {
                    for (int k = j + 1; k <= numberArr.length - m + 2; k++) {
                        for (int l = k + 1; l <= numberArr.length - m + 3; l++) {
                            for (int n = l + 1; n <= numberArr.length - m + 4; n++) {
                                for (int o = n + 1; o <= numberArr.length - m + 5; o++) {
                                    row[0] = numberArr[i];
                                    row[1] = numberArr[j];
                                    row[2] = numberArr[k];
                                    row[3] = numberArr[l];
                                    row[4] = numberArr[n];
                                    row[5] = numberArr[o];

                                    if (hasEvens(row) && hasOdds(row) && hasConsecutive(row) && hasSameEndings(row) && hasSameDecade(row)) {
                                        ps.println(Arrays.toString(row));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Calculates the even numbers.
     *
     * @param row       a combination of 6 numbers.
     * @return          true, if there are up to 4 even numbers,
     *                  false otherwise.
     */
    public static boolean hasEvens(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num % 2 == 0) count++;
        }
        return count <= 4;
    }

    /**
     * Calculates the odd numbers.
     *
     * @param row       a combination of numbers.
     * @return          true, if there are up to 4 odd numbers,
     *                  false otherwise.
     */
    public static boolean hasOdds(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num % 2 != 0) count++;
        }
        return count <= 4;
    }

    /**
     * Calculates the consecutive numbers.
     *
     * @param row       a combination of numbers.
     * @return          true, if there are up to 2 consecutive numbers,
     *                  false otherwise.
     */
    public static boolean hasConsecutive(int[] row){
        int count = 0;       // count 3 consecutive numbers
        for (int i = 0; i < row.length - 2; i++) {
            if (row[i] == row[i+1] - 1 && row[i+1] == row[i+2] - 1) {
                count++;
            }
        }
        return count == 0;
    }

    /**
     * Calculates how many numbers have the same ending.
     *
     * @param row       a combination of numbers.
     * @return          true, if there are up to 3 numbers with the same ending,
     *                  false otherwise.
     */
    public static boolean hasSameEndings(int[] row) {
        int[] endings = new int[10];
        for (int num : row) {
            endings[num % 10]++;
        }
        for (int ending : endings) {
            if (ending > 3) return false;
        }
        return true;
    }

    /**
     * Calculates the numbers that are in the same decade.
     *
     * @param row       a combination of numbers.
     * @return          true, if there are up to 3 numbers in the same decade,
     *                  false otherwise.
     */
    public static boolean hasSameDecade(int[] row) {
        int[] decades = new int[5];     // because input numbers are 1-49.

        for (int num : row) {
            decades[num / 10]++;
        }
        for (int decade : decades) {
            if (decade > 3) return false;
        }
        return true;
    }
}
