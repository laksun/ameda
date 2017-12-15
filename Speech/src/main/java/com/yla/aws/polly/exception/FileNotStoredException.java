package com.yla.aws.polly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="File Not Stored")
public class FileNotStoredException extends Exception {
	
	private static final long serialVersionUID = -3441123468343445380L;
	public FileNotStoredException(int id) {
		super("FileNotStoredException with id="+id);
	}

}
