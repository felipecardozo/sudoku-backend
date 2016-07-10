package com.sudoku;

public class SudokuBoard {

	private int[][] sudokuBoard;

	public SudokuBoard() {
		// sudokuBoard = new int[] { 1, 2, 3, 4, 6, 0 };
		sudokuBoard = new int[][] { { 7, 0, 0, 0, 4, 0, 5, 3, 0 }, { 0, 0, 5, 0, 0, 8, 0, 1, 0 },
				{ 0, 0, 8, 5, 0, 9, 0, 4, 0 }, { 5, 3, 9, 0, 6, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 5 },
				{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, { 9, 0, 7, 4, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 5, 7, 0, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };
	}

	public int[][] getSudokuBoard() {
		return sudokuBoard;
	}

	public void setSudokuBoard(int[][] sudokuBoard) {
		this.sudokuBoard = sudokuBoard;
	}

}
