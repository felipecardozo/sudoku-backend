package com.sudoku;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {

	@RequestMapping("/sudoku")
	public SudokuBoard getBoard() {
		return new SudokuBoard();
	}

}
