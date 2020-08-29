package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  // NO JAVADOC
  @Test
  public void testValidBoardNoWinner() { // Given Test
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testXWins() { //tests standard case, and case insensitivity
    TicTacToeBoard board = new TicTacToeBoard("Xo..xo.OX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testOWins() { //tests standard case, and case insensitivity
    TicTacToeBoard board = new TicTacToeBoard("oOoX..X.x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testUnreachableBoard() { //tests unreachable statement case, and case insensitivity
    TicTacToeBoard boardX = new TicTacToeBoard("xxXxxxXXx");
    assertEquals(Evaluation.UnreachableState, boardX.evaluate());
  }
}
