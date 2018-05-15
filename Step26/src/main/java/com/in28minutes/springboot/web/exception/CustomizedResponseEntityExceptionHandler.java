package com.in28minutes.springboot.web.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FlashCardNotFoundException.class)
	public final ResponseEntity<Object> handleFlashCardNotFoundException(FlashCardNotFoundException fl,
			WebRequest request) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), fl.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionresponse, HttpStatus.NOT_FOUND);
	}

}
