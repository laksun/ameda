package com.yla.aws.polly.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
	
private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "error/database_error";
	}
	
	
	//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public String handleIOException(){
		logger.error("IOException handler executed");
		return "error/404";
	}
	
	@ExceptionHandler(com.mongodb.MongoSocketOpenException.class)
	public String handleMongoDBException() {
		return "error/mongoDB_error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error(ex.getMessage());
		return "error/error";
	}
	
	//to return JSON message
	@ExceptionHandler(EmployeeNotFoundException.class)
	public @ResponseBody ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		return response;
		
	}
	
	
	
	
	

}
