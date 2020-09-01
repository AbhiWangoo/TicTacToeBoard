package com.example;

import java.util.*;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
    private final String[][] BOARDARRAY; // not final in case it needs to be made null
    private static int dimension;
    private String winner;

    /**
     * This method should load a string into your TicTacToeBoard class.
     *
     * @param board The string representing the board
     */
    public TicTacToeBoard(String board) {
        winner = "";
        dimension = 3;
        int stringIndex = 0;
        BOARDARRAY = new String[dimension][dimension];


        if (!IsValidBoard(board))
            winner = "US"; // US == Unreachable state
        else {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
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
        if (winner.compareTo("US") == 0 || BOARDARRAY == null) {
            return Evaluation.UnreachableState;
        }

        // Row and column checks
        for (int i = 0; i < 3; i++) {
            if (CheckRow(BOARDARRAY, i)) { // Checks row victory
                winner += BOARDARRAY[i][0];
            } else if (CheckCol(BOARDARRAY, i)) { // Checks column victory
                winner += BOARDARRAY[0][i];
            }
        }

        // Diagonals Check
        if (CheckLeftDiagonal(BOARDARRAY))
            winner = BOARDARRAY[0][0];
        else if (CheckRightDiagonal(BOARDARRAY))
            winner = BOARDARRAY[0][dimension - 1];

        // Conversion of winner variable to Evaluation enum type
        if(winner.length() > 1) // if multiple winners, its an unreachable state
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
     * private helper method to aide in evaluate().
     *
     * @param row   represents index for row to check for matching values
     * @param board represents BOARDARRAY reference
     * @return boolean for a match in the row or column
     */
    private boolean CheckRow(String[][] board, int row) { // check to see if there is a matching row
        if (board[row][0].toLowerCase().compareTo("x") != 0 && board[row][0].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of row

        for (int i = 0; i < board.length - 1; i++) {
            if (board[row][i].toLowerCase().compareTo(board[row][i + 1].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate().
     *
     * @param col   represents index for column to check for matching values
     * @param board represents BOARDARRAY reference
     * @return boolean for a match in the row or column
     */
    private boolean CheckCol(String[][] board, int col) { // check to see if there is a matching column
        if (board[0][col].toLowerCase().compareTo("x") != 0 && board[0][col].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of column

        for (int i = 0; i < board[col].length - 1; i++) {
            if (board[i][col].toLowerCase().compareTo(board[i + 1][col].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate().
     *
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean CheckLeftDiagonal(String[][] board) { // Checks diagonal from the upper left to bottom right
        if (board[0][0].toLowerCase().compareTo("x") != 0 && board[0][0].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of left diagonal

        for (int i = 0; i < dimension - 1; i++) {
            if (board[i][i].toLowerCase().compareTo(board[i + 1][i + 1].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate().
     *
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean CheckRightDiagonal(String[][] board) { // Checks diagonal from the upper right to bottom left
        if (board[0][dimension - 1].toLowerCase().compareTo("x") != 0 && board[0][dimension - 1].toLowerCase().compareTo("o") != 0)
            return false; // Checks for either x or o at beginning of right diagonal

        for (int i = 0; i < dimension - 1; i++) {
            if (board[i][dimension - i - 1].toLowerCase().compareTo(board[i + 1][dimension - i - 2].toLowerCase()) != 0)
                return false;
        }
        return true;
    }

    /**
     * private helper method to aide in evaluate(), lower space complexity and
     * time complexity for traversal of string
     *
     * @param board represents BOARDARRAY reference
     * @return String when the match is required
     */
    private boolean IsValidBoard(String board) { // Checks validity of board as a Tic-Tac-Toe dimension by dimension
        if (board == null || !(board instanceof String) || board.length() != dimension * dimension)
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
