package com.bank.exception;

public class IncorrectInputException extends Exception {

	private static final long serialVersionUID = -7368842698996944071L;

	public IncorrectInputException() {
		super();
	}
	
	public IncorrectInputException(String msg) {
		super(msg);
	}
		
	public IncorrectInputException(String msg, Throwable reason) {
		super(msg, reason);
	}
}


