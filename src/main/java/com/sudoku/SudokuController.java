package com.sudoku;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SudokuController {

	@RequestMapping(value = "/sudoku", method = RequestMethod.GET)
	public SudokuBoard getBoard() {
		return new SudokuBoard();
	}

	@RequestMapping(value = "/sudoku", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SudokuMoveOutput setMovement(@RequestBody SudokuMoveInput sudokuInput) throws Exception {
		if ((sudokuInput.getMoveColumn() < 0 || sudokuInput.getMoveColumn() > 9)
				|| (sudokuInput.getMoveRow() < 0 || sudokuInput.getMoveRow() > 9)
				|| (sudokuInput.getMoveValue() < 0 || sudokuInput.getMoveValue() > 9)) {
			throw new Exception();
		}
		if (sudokuInput.getMoveValue() == 7) {
			throw new IllegalArgumentException();
		}
		if (sudokuInput.getMoveValue() == 9) {
			int gameOver[][] = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
					{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
					{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
					{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
			return new SudokuMoveOutput(gameOver, 0, 0, true, true);
		}
		return new SudokuMoveOutput();
	}

	@ExceptionHandler(Exception.class)
	public void handleBadRequests(HttpServletResponse response) throws IOException {
		// response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again
		// and with a non empty string as 'name'");
		response.setStatus(HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public SudokuMoveOutput handleBadRequestsIllegalArgumentException(HttpServletResponse response) throws IOException {
		SudokuMoveOutput board = new SudokuMoveOutput();
		board.setBoard(null);
		board.setConflictColumn(4);
		board.setConflictColumn(3);
		board.setValid(false);
		board.setGameOver(false);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		return board;
	}

}
