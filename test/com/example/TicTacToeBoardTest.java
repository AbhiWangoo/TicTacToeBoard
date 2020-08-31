package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
    //
    @Test
    public void testBoardEmpty() { // Given Test
        try {
            new TicTacToeBoard("");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testBoardNull() {
        try {
            new TicTacToeBoard(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testBoardMultiWinners() {
        TicTacToeBoard boardMultiWinner = new TicTacToeBoard("Ooo...xxc");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner.evaluate());
    }

    @Test
    public void testValidBoardNoWinner() {
        TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
        assertEquals(Evaluation.NoWinner, board.evaluate());
    }

    @Test
    public void testXWinsRow1() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("Xxx.O.o5o");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRow2() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("qo.xXXo.o");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRow3() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard(".oko.oxXx");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol1() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xoox-ox.f");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol2() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("oxo_xo.x-");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol3() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("ooxeox.ux");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsLeftDiagonal() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xqo_x_oox");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRightDiagonal() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("o.x_x_xoo");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testOWinsRow1() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("ooox.x..x");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRow2() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("qx.ooox.x");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRow3() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xxkx.xOoO");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol1() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("OXXo_xo__");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol2() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xox_oxxo.");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol3() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xxoexo.uo");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsLeftDiagonal() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("oqx_o_xxo");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRightDiagonal() { //tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("x.OxO_OXX");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testUnreachableBoard() { //tests unreachable statement case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xxXxxxXXx");
        assertEquals(Evaluation.UnreachableState, board.evaluate());
    }
}
