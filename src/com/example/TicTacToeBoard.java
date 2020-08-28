package com.example;
import java.util.*;
/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  private String board;
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    this.board = board;
  } //MAYBE NEEDS TO BE DONE DELETE THIS COMMENT BEFORE YOU SUBMIT

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    String[][] boardArray = ConvertStringTo2DArray(board, 3, 3); // to traverse, convert board string to a 2d array
    String rv = ""; // return value as a string

    for(int i = 0; i < 3 ; i++){
      System.out.println(i + " " + CheckRowCol(boardArray[i][0], boardArray[i][1], boardArray[i][2]));
      if(CheckRowCol(boardArray[i][0], boardArray[i][1], boardArray[i][2])) { // Checks row victory
        rv = boardArray[i][0];
        System.out.println("Winner Found, " + rv);
      } else if (CheckRowCol(boardArray[0][i], boardArray[1][i], boardArray[2][i])) { // Checks column victory
        rv = boardArray[0][i];
        System.out.println("Winner Found, " + rv);
      }
    }

    // Diagonals Check

    switch (rv.toLowerCase()) { // Conversion of rv to Evaluation enum type
      case("x"):
        return Evaluation.Xwins;

      case("o"):
        return Evaluation.Owins;

      default:
        return Evaluation.NoWinner;
    }
  }

  // helper functions below

  private boolean CheckRowCol(String a, String b, String c){ // check to see if there is a matching row or not
    String aL = a.toLowerCase(); // For case insensitivity
    String bL = b.toLowerCase();
    String cL = c.toLowerCase();
    return (aL.compareTo("x") == 0 || aL.compareTo("o") == 0) && (aL.compareTo(bL) == 0 && bL.compareTo(cL) == 0);
  }
  public String[][] ConvertStringTo2DArray(String stringBoard, int rows, int columns){ // implementation of String to 2Darray conversion
    String[][] rv = new String[rows][columns];
    int stringIndex = 0;
    for(int i = 0; i < rows;i++){
      for(int j = 0;j < columns;j++){
        rv[i][j] = stringBoard.substring(stringIndex,stringIndex+1);
        stringIndex++;
      }
    }
    return rv;
  }
}
