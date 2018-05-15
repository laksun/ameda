package com.in28minutes.springboot.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlashCardNotFoundException extends RuntimeException {

	public FlashCardNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlashCardNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public FlashCardNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public FlashCardNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FlashCardNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

}
