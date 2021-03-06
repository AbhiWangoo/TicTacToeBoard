package com.example;

import java.util.*;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
    private final String[][] BOARDARRAY; // 2D Array the String will be loaded into
    private final int DIMENSION; // board size specification
    private String winner;

    /**
     * This method loads a string into your TicTacToeBoard class.
     *
     * @param board The string representing the board
     */
    public TicTacToeBoard(String board) {
        winner = "";
        DIMENSION = 3;
        int stringIndex = 0;
        BOARDARRAY = new String[DIMENSION][DIMENSION];


        if (!isValidBoard(board))
            winner = "US"; // US == Unreachable state
        else {
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    BOARDARRAY[i][j] = board.substring(stringIndex, stringIndex + 1);
                    stringIndex++;
                }
            }
        }

    }

    /**
     * Checks the state of the board (unreachable, no winner, X wins, or O wins)
     *
     * @return an enum value corresponding to the board evaluation
     */
    public Evaluation evaluate() {
        // Unreachable check
        if (winner.compareTo("US") == 0) {
            return Evaluation.UnreachableState;
        }

        // Row and column checks
        for (int i = 0; i < 3; i++) {
            if (checkRow(BOARDARRAY, i)) { // Checks row victory
                winner += BOARDARRAY[i][0];
            } else if (checkCol(BOARDARRAY, i)) { // Checks column victory
                winner += BOARDARRAY[0][i];
            }
        }

        // Diagonals Check
        if (checkLeftDiagonal(BOARDARRAY))
            winner = BOARDARRAY[0][0];
        else if (checkRightDiagonal(BOARDARRAY))
            winner = BOARDARRAY[0][DIMENSION - 1];

        // Conversion of winner variable to Evaluation enum type
        if (winner.length() > 1) // if multiple winners, its an unreachable state
            return Evaluation.UnreachableState;
        switch (winner.toLowerCase()) {
            case ("x"):
                return Evaluation.Xwins;

            case ("o"):
                return Evaluation.Owins;

            default:
                return Evaluation.NoWinner;
        }
    }

    // helper functions below

    /**
     * private helper method to aide in evaluate(), checks to see whether entire row
     * in String[][] board is the same value
     *
     * @param row   represents index for row to check for matching values
     * @param board represents BOARDARRAY reference
     * @return boolean for a match in the row or column
     */
    private boolean checkRow(String[][] board, int row) {
        if (board[row][0].toLowerCase().compareTo("x") != 0 && board[row][0].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of row

        for (int i = 0; i < board.length - 1; i++) {
            if (board[row][i].toLowerCase().compareTo(board[row][i + 1].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate(), checks to see whether entire column
     * in String[][] board is the same value
     *
     * @param col   represents index for column to check for matching values
     * @param board represents BOARDARRAY reference
     * @return boolean for a match in the row or column
     */
    private boolean checkCol(String[][] board, int col) {
        if (board[0][col].toLowerCase().compareTo("x") != 0 && board[0][col].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of column

        for (int i = 0; i < board[col].length - 1; i++) {
            if (board[i][col].toLowerCase().compareTo(board[i + 1][col].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate(), checks to see whether entire left to right
     * diagonal of String[][] board has equal values
     *
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean checkLeftDiagonal(String[][] board) {
        if (board[0][0].toLowerCase().compareTo("x") != 0 && board[0][0].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of left diagonal

        for (int i = 0; i < DIMENSION - 1; i++) {
            if (board[i][i].toLowerCase().compareTo(board[i + 1][i + 1].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate(), checks to see whether entire right to left
     * diagonal of String[][] board has equal values
     *
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean checkRightDiagonal(String[][] board) {
        if (board[0][DIMENSION - 1].toLowerCase().compareTo("x") != 0 && board[0][DIMENSION - 1].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of right diagonal

        for (int i = 0; i < DIMENSION - 1; i++) {
            if (board[i][DIMENSION - i - 1].toLowerCase().compareTo(board[i + 1][DIMENSION - i - 2].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate(), determines whether board is
     * valid for the purpose of evaulate()
     *
     * @throws IllegalArgumentException if String state is incorrect for tic-tac-toe
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean isValidBoard(String board) {
        if (board == null || board.length() != DIMENSION * DIMENSION)
            throw new IllegalArgumentException(); // checks correct String state

        int xCount = 0; // number of x values in the string
        int oCount = 0; // number of x values in the string
        for (int i = 0; i < board.length(); i++) {
            if (board.substring(i, i + 1).toLowerCase().compareTo("x") == 0)
                xCount++;
            else if (board.substring(i, i + 1).toLowerCase().compareTo("o") == 0)
                oCount++;
        }
        // returning whether there are either 1 or 0 more X values in the String than O values
        return (xCount - oCount == 0 || xCount - oCount == 1);
    }
}
