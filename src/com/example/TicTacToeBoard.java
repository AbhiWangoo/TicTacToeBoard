package com.example;
import java.util.*;
/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  private String[][] boardArray;
  private static int dimension; //come up with a better name
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    dimension = 3;
    int stringIndex = 0;
    boardArray = new String[dimension][dimension];
    for(int i = 0; i < dimension;i++){
      for(int j = 0;j < dimension;j++){
        boardArray[i][j] = board.substring(stringIndex,stringIndex+1);
        stringIndex++;
      }
    }
  } //MAYBE NEEDS TO BE DONE DELETE THIS COMMENT BEFORE YOU SUBMIT

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  //JAVADOC
  public Evaluation evaluate() {
    // MAKE 3 A CONSTANT
    String winner = "No Winner";

    for(int i = 0; i < 3 ; i++){
      if(CheckRow(boardArray, i)) { // Checks row victory
        winner = boardArray[i][0];
      } else if(CheckCol(boardArray, i)) { // Checks column victory
        winner = boardArray[0][i];
      }
    }

    // Diagonals Check

    switch (winner.toLowerCase()) { // Conversion of winner variable to Evaluation enum type
      case("x"):
        return Evaluation.Xwins;

      case("o"):
        return Evaluation.Owins;

      case("Unreachable State"):
        return Evaluation.UnreachableState;

      default:
        return Evaluation.NoWinner;
    }
  }

  // helper functions below
  /**
   * private helper method to aide in evaluate().
   * @param row represents index for row to check for matching values
   * @param board represents boardArray reference
   * @return boolean for a match in the row or column
   */
  private boolean CheckRow(String[][] board,int row){ // check to see if there is a matching row or column
    for(int i = 0 ; i < board.length-1 ; i ++) {
      if(board[row][i].toLowerCase().compareTo(board[row][i+1].toLowerCase()) == 0)
        continue;
      else
        return false;
    }
    return true;
  }
  /**
   * private helper method to aide in evaluate().
   * @param col represents index for column to check for matching values
   * @param board represents boardArray reference
   * @return boolean for a match in the row or column
   */
  private boolean CheckCol(String[][] board, int col){ // check to see if there is a matching row or column
    for(int i = 0 ; i < board[col].length-1 ; i ++) {
      if(board[i][col].toLowerCase().compareTo(board[i+1][col].toLowerCase()) == 0)
        continue;
      else
        return false;
    }
    return true;
  }
}
