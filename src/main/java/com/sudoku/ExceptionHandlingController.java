package com.sudoku;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

	private final static Logger LOG = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "problem errrr") // 409
	@ExceptionHandler(Exception.class)
	public void conflict() {
		LOG.info("felipe error aasdjsadj ************************s");
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
			HttpRequestMethodNotSupportedException.class, Exception.class })
	public void badRequest(HttpServletRequest req, Exception exception) {
		LOG.info("felipe error aasdjsadj ************************s");
	}

}
