package com.sudoku;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {

	@RequestMapping(value = "/sudoku", method = RequestMethod.GET)
	public SudokuBoard getBoard() {
		return new SudokuBoard();
	}

	@RequestMapping(value = "/sudoku", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SudokuMoveOutput setMovement(@RequestBody SudokuMoveInput sudokuInput) {
		return new SudokuMoveOutput();
	}

}
