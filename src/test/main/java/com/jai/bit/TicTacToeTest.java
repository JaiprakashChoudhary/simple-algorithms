package com.jai.bit;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author jaiprakash
 */
public class TicTacToeTest {

  private void playRowMoves(int size, TicTacToe ticTacToe) {
    Assert.assertFalse(IntStream.range(0, size - 1).anyMatch(
        value -> ticTacToe.move(0, 0, value)));
    Assert.assertTrue(ticTacToe.move(0, 0, size - 1));
  }

  private void playColumnMoves(int size, TicTacToe ticTacToe) {
    Assert.assertFalse(IntStream.range(0, size - 1).anyMatch(
        value -> ticTacToe.move(0, value, 0)));
    Assert.assertTrue(ticTacToe.move(0, size - 1, 0));
  }

  private void playDiagonalMoves(int size, TicTacToe ticTacToe) {
    Assert.assertFalse(IntStream.range(0, size - 1).anyMatch(
        value -> ticTacToe.move(0, value, value)));
    Assert.assertTrue(ticTacToe.move(0, size - 1, size - 1));
  }

  private void playCrossDiagonalMoves(int size, TicTacToe ticTacToe) {
    Assert.assertFalse(IntStream.range(0, size - 1).anyMatch(
        value -> ticTacToe.move(0, size-1-value, value)));
    Assert.assertTrue(ticTacToe.move(0, 0, size - 1));
  }

  private void playForSize(int size) {
    TicTacToe ticTacToe = new TicTacToe(size, 2);
    playRowMoves(size, ticTacToe);
    ticTacToe = new TicTacToe(size, 2);
    playColumnMoves(size,ticTacToe);
    ticTacToe = new TicTacToe(size, 2);
    playDiagonalMoves(size,ticTacToe);
    ticTacToe = new TicTacToe(size, 2);
    playCrossDiagonalMoves(size,ticTacToe);
  }

  @Test
  public void playForSize3() {
    playForSize(3);
  }

  @Test
  public void playForSize4() {
    playForSize(4);
  }

  @Test
  public void playForSize5() {
    playForSize(5);
  }
}