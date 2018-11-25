package com.jai.bit;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * The tic tac toe can be checked for completion in many ways.
 * The O(1) solution can be done by having two array's of length no. of rows + no. of columns + no. of diagonals.
 * On every move we increment the counter of the corresponding
 *
 * @author jaiprakash
 */

public class TicTacToe {

  private Predicate<Integer> checkForWin() {
    return pIdx -> Arrays.stream(baseArray[pIdx]).anyMatch(x -> x == (1 << length) - 1);
  }

  private BiConsumer<Integer, Integer> takeNextMove() {
    return (pIdx, xPos) -> baseArray[pIdx][xPos] = baseArray[pIdx][xPos] << 1 | 1;
  }

  private int[][] baseArray;
  private int length;

  public TicTacToe(int size, int players) {
    baseArray = new int[players][size * 2 + 2];
    length = size;
  }

  public TicTacToe(int size) {
    this(size, 2);
  }

  public boolean move(int pIdx, int xPos, int yPos) {
    takeNextMove().accept(pIdx, xPos);
    takeNextMove().accept(pIdx, length + yPos);
    if (xPos == yPos)
      takeNextMove().accept(pIdx, 2 * length);
    if (xPos + yPos == length-1)
      takeNextMove().accept(pIdx, 2 * length + 1);
    return checkForWin().test(pIdx);
  }
}