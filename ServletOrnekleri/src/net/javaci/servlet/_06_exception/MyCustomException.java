package net.javaci.servlet._06_exception;

public class MyCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MyCustomException(String msg) {
		super(msg);
	}
}
