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
