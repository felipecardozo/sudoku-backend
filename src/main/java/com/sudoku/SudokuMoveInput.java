package com.sudoku;

public class SudokuMoveInput {

	private int sudokuBoard[][];
	private int moveRow;
	private int moveColumn;
	private int moveValue;

	public SudokuMoveInput() {

	}

	public SudokuMoveInput(int sudokuBoard[][], int moveRow, int moveColumn, int moveValue) {
		super();
		this.sudokuBoard = sudokuBoard;
		this.moveRow = moveRow;
		this.moveColumn = moveColumn;
		this.moveValue = moveValue;
	}

	public int[][] getSudokuBoard() {
		return sudokuBoard;
	}

	public void setSudokuBoard(int[][] sudokuBoard) {
		this.sudokuBoard = sudokuBoard;
	}

	public int getMoveRow() {
		return moveRow;
	}

	public void setMoveRow(int moveRow) {
		this.moveRow = moveRow;
	}

	public int getMoveColumn() {
		return moveColumn;
	}

	public void setMoveColumn(int moveColumn) {
		this.moveColumn = moveColumn;
	}

	public int getMoveValue() {
		return moveValue;
	}

	public void setMoveValue(int moveValue) {
		this.moveValue = moveValue;
	}

}
