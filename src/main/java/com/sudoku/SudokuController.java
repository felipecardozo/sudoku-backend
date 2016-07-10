package com.sudoku;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {

	@RequestMapping(value = "/sudoku", method = RequestMethod.GET)
	public SudokuBoard getBoard() {
		return new SudokuBoard();
	}

	@RequestMapping(value = "/sudoku", method = RequestMethod.PUT)
	public String setMovement() {
		return "";
	}

}
