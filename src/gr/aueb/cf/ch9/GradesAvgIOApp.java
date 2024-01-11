package gr.aueb.cf.ch9;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Program reads from a file the name, lastname and grades of students.
 * Then, the average grade is calculated for each student and it is printed
 * to a separate file (primOut.txt). If there is wrong input in grades,
 * it is logged in the log.txt file.
 *
 * @author Thodoris
 */
public class GradesAvgIOApp {

    public static void main(String[] args) {
        String line = "";
        try(BufferedReader bf = new BufferedReader(new FileReader("C:/tmp/grades.txt", StandardCharsets.UTF_8));
            PrintStream psGrades = new PrintStream(new FileOutputStream("C:/tmp/primOut.txt"), true, StandardCharsets.UTF_8);
            PrintStream psLogs = new PrintStream(new FileOutputStream("C:/tmp/log.txt"), true, StandardCharsets.UTF_8)) {

            psGrades.printf("%-15s | %-15s| ΜΈΣΟΣ ΌΡΟΣ\n%s\n", "ΌΝΟΜΑ", "ΕΠΏΝΥΜΟ", "-".repeat(50));
            while ((line = bf.readLine()) != null) {
                printAverageGrade(psGrades, psLogs, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO error!");
        }
    }

    /**
     * Calculates and prints to the file the average grade for each student.
     * If there is wrong input in grades, a log is created in log.txt file.
     *
     * @param psGrades      PrintStream for average grades file.
     * @param psLogs        PrintStream for logs file.
     * @param line          line containing name and grades.
     */
    public static void printAverageGrade(PrintStream psGrades, PrintStream psLogs, String line) {
        double sum = 0;
        double avg = 0;
        String[] studentGrades = line.split(" +");
        if (studentGrades.length == 1) return;
        if (studentGrades.length == 2) {
            psLogs.println("Ελλιπή δεδομένα");
            return;
        }
        psGrades.printf("%-15s | %-15s| ", studentGrades[0], studentGrades[1]);
        for (int i = 2; i < studentGrades.length; i++) {
            if (!isValid(studentGrades[i])) {
                psLogs.printf("Μαθητής: %s %s - Λάθος δεδομένα\n", studentGrades[0], studentGrades[1]);
                psGrades.println("Λάθος δεδομένα");
                return;
            }
            sum += Double.parseDouble(studentGrades[i]);
        }
        avg = sum / (studentGrades.length - 2);
        psGrades.println(avg);
    }

    /**
     * Checks if the grade is valid (0-10).
     *
     * @param grade     the input grade.
     * @return          true, if grade is valid, false otherwise.
     */
    public static boolean isValid(String grade) {
        double gradeNum = 0;
        try {
            gradeNum = Double.parseDouble(grade);
        } catch(NumberFormatException e) {
            return false;
        }
        return gradeNum >= 0 && gradeNum <= 10;
    }
}
