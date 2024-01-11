package gr.aueb.cf.ch10.project04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classic Tic-Tac-Toe game for 2 players.
 *
 * @author Thodoris
 */
public class TicTacToe {
    static String[][] gameTable = new String[3][3];
    static Scanner sc = new Scanner(System.in);
    static int filledPositions = 0;

    public static void main(String[] args) {
        String response = "";
        String[] players = new String[2];
        int currentPlayer = 0;
        String currentValue = "X";
        int line = 0;
        int col = 0;

        System.out.print("Welcome to tic-tac-toe game! Are you ready to play? (press y for yes or any other button " +
                            "to exit): ");
        response = sc.next();
        if (!response.equals("y")) {
            System.out.println("Goodbye! " + Character.toString(128075));
            System.exit(1);
        }
        initGameTable();
        sc.nextLine();
        System.out.print("Player 1 please enter your name: ");
        players[0] = sc.nextLine().trim();
        System.out.print("Player 2 please enter your name: ");
        players[1] = sc.nextLine().trim();
        currentPlayer = getRandomPlayer() - 1;
        System.out.printf("%s plays first (randomly generated)%n", players[currentPlayer]);
        printTable();

        while (true) {
            System.out.printf("%s it is your turn (%s).%n", players[currentPlayer], currentValue);
            while (true) {
                line = getValidLine();
                col = getValidCol();
                if (!isOccupied(line, col)) break;
                System.out.println("This position is already played!");
            }
            gameTable[line - 1][col - 1] = currentValue;
            filledPositions++;
            printTable();
            if (isWinning()) {
                System.out.printf("%s won the game! %s%n", players[currentPlayer], Character.toString(127881));
                break;
            }
            if (isFull()) {
                System.out.println("The game is a draw.");
                break;
            }
            currentPlayer = (currentPlayer == 1) ? 0 : 1;               // Switch player for the next round.
            currentValue = (currentValue.equals("X")) ? "O" : "X";      // Switch symbol for the next round.
        }
        System.out.printf("Thank you for using the game! %s Goodbye!", Character.toString(128075));
    }

    /**
     * Fill game table with empty strings.
     */
    public static void initGameTable() {
        for (String[] row : gameTable) {
            Arrays.fill(row, " ");
        }
    }

    /**
     * Prints the tic-tac-toe game table in a more user-friendly format.
     */
    public static void printTable() {
        System.out.println("\n\t1   2   3");
        for (int i = 0; i < gameTable.length; i++) {

            System.out.println("  " + "\ufe4d".repeat(8));
            System.out.print(i+1 + " ");
            System.out.print("\u23d0");
            for (int j = 0 ; j < gameTable[i].length; j++) {
                System.out.printf(" %s \u23d0", gameTable[i][j]);
            }
            System.out.println();
        }
        System.out.println("  " + "\ufe4d".repeat(8));
    }

    /**
     * Get random number between 1 and 2 to decide the player to play first.
     *
     * @return      random number between 1 and 2.
     */
    public static int getRandomPlayer() {
        return (int) (Math.random() * 2 + 1);
    }

    /**
     * Checks if all possible positions in the game table are filled.
     *
     * @return      true, if the table is filled,
     *              false otherwise.
     */
    public static boolean isFull() {
        return filledPositions == 9;
    }

    /**
     * Checks if a particular position (defined by line and column)
     * in the game table is already played.
     *
     * @param line      line position.
     * @param col       column position.
     * @return          true, if the position is already played,
     *                  false otherwise.
     */
    public static boolean isOccupied(int line, int col) {
        return !gameTable[line - 1][col - 1].equals(" ");
    }

    /**
     * Get valid choice for line (1-3).
     *
     * @return      the valid line number.
     */
    public static int getValidLine() {
        int line = 0;
        while (true) {
            try {
                System.out.print("Choose line (1-3): ");
                line = sc.nextInt();
                if (line < 1 || line > 3) throw new Exception("This number is not valid to play.");
                return line;
            } catch (InputMismatchException e) {
                System.out.println("Only numbers are acceptable.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sc.nextLine();
        }
    }

    /**
     * Get valid choice for column (1-3).
     *
     * @return      the valid column number.
     */
    public static int getValidCol() {
        int col = 0;
        while (true) {
            try {
                System.out.print("Choose column (1-3): ");
                col = sc.nextInt();
                if (col < 1 || col > 3) throw new Exception("This number is not valid to play.");
                return col;
            } catch (InputMismatchException e) {
                System.out.println("Only numbers are acceptable.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sc.nextLine();
        }
    }

    /**
     * Checks if there is a winning combination in the game.
     *
     * @return      true, if there is a winning combination,
     *              false otherwise.
     */
    public static boolean isWinning() {
        for (int i = 0; i < gameTable.length; i++) {
            if (gameTable[i][0].equals(gameTable[i][1]) && gameTable[i][0].equals(gameTable[i][2]) && !gameTable[i][0].equals(" ")) {
                return true;
            }
            if (gameTable[0][i].equals(gameTable[1][i]) && gameTable[0][i].equals(gameTable[2][i]) && !gameTable[0][i].equals(" ")) {
                return true;
            }
        }
        if (gameTable[0][0].equals(gameTable[1][1]) && gameTable[1][1].equals(gameTable[2][2]) && !gameTable[0][0].equals(" ")) {
            return true;
        }
        return gameTable[0][2].equals(gameTable[1][1]) && gameTable[1][1].equals(gameTable[2][0]) && !gameTable[0][2].equals(" ");
    }
}
