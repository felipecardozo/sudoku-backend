package com.sudoku;

public class SudokuMoveOutput {

	private int[][] board;
	private int conflictRow;
	private int conflictColumn;
	private boolean valid;
	private boolean gameOver;

	public SudokuMoveOutput() {
		board = new int[][] { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 0 } };
		conflictColumn = 0;
		conflictRow = 0;
		valid = true;
		gameOver = false;
	}

	public SudokuMoveOutput(int[][] board, int conflictRow, int conflictColumn, boolean valid, boolean gameOver) {
		super();
		this.board = board;
		this.conflictRow = conflictRow;
		this.conflictColumn = conflictColumn;
		this.valid = valid;
		this.gameOver = gameOver;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getConflictRow() {
		return conflictRow;
	}

	public void setConflictRow(int conflictRow) {
		this.conflictRow = conflictRow;
	}

	public int getConflictColumn() {
		return conflictColumn;
	}

	public void setConflictColumn(int conflictColumn) {
		this.conflictColumn = conflictColumn;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
