package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
    // UnreachableState cases
    @Test
    public void testUnreachableBoard() { //tests unreachable statement case, and case insensitivity
        TicTacToeBoard boardX = new TicTacToeBoard("xxXxxxXXx");
        assertEquals(Evaluation.UnreachableState, boardX.evaluate());

        TicTacToeBoard boardO = new TicTacToeBoard("oooOOoOOO");
        assertEquals(Evaluation.UnreachableState, boardO.evaluate());
    }

    @Test
    public void testBoardMultiWinnersRows() { // Tests multiple row winners
        TicTacToeBoard boardMultiWinner = new TicTacToeBoard("Ooo...xxx");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner.evaluate());

        TicTacToeBoard boardMultiWinner1 = new TicTacToeBoard("...Oooxxx");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner1.evaluate());

        TicTacToeBoard boardMultiWinner2 = new TicTacToeBoard("...xxxOoo");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner2.evaluate());

        TicTacToeBoard boardMultiWinner3 = new TicTacToeBoard("xxxOoo...");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner3.evaluate());

        TicTacToeBoard boardMultiWinner4 = new TicTacToeBoard("Oooxxx...");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner4.evaluate());

        TicTacToeBoard boardMultiWinner5 = new TicTacToeBoard("xxx...OOo");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner5.evaluate());
    }

    @Test
    public void testBoardMultiWinnersCols() { // Tests multiple column winners
        TicTacToeBoard boardMultiWinner = new TicTacToeBoard("Ox.ox.oX.");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner.evaluate());

        TicTacToeBoard boardMultiWinner1 = new TicTacToeBoard("xo.XO.Xo.");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner1.evaluate());

        TicTacToeBoard boardMultiWinner2 = new TicTacToeBoard("x.oX.ox.O");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner2.evaluate());

        TicTacToeBoard boardMultiWinner3 = new TicTacToeBoard("o.XO.xO.x");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner3.evaluate());

        TicTacToeBoard boardMultiWinner4 = new TicTacToeBoard(".oX.OX.OX");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner4.evaluate());

        TicTacToeBoard boardMultiWinner5 = new TicTacToeBoard(".XO.Xo.xo");
        assertEquals(Evaluation.UnreachableState, boardMultiWinner5.evaluate());
    }


    @Test
    public void testBoardEmpty() { // Tests IllegalArgumentException
        try {
            new TicTacToeBoard("");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testBoardNull() { // Tests IllegalArgumentException
        try {
            new TicTacToeBoard(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }


    // NoWinnerTests
    @Test
    public void testValidBoardNoWinner() { // Tests board without winner
        TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
        assertEquals(Evaluation.NoWinner, board.evaluate());
    }


    // Basic win tests
    @Test
    public void testXWinsRow1() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("Xxx.O.o5o");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRow2() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("qo.xXXo.o");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRow3() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard(".oko.oxXx");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol1() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xoox-ox.f");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol2() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("oxo_xo.x-");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsCol3() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("ooxeox.ux");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsLeftDiagonal() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xqo_x_oox");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testXWinsRightDiagonal() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("o.x_x_xoo");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testOWinsRow1() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("ooox.x..x");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRow2() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("qx.ooox.x");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRow3() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xxkx.xOoO");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol1() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("OXXo_xo__");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol2() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xox_oxxo.");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsCol3() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("xxoexo.uo");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsLeftDiagonal() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("oqx_o_xxo");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testOWinsRightDiagonal() { // Tests standard case, and case insensitivity
        TicTacToeBoard board = new TicTacToeBoard("x.OxO_OXX");
        assertEquals(Evaluation.Owins, board.evaluate());
    }
}
