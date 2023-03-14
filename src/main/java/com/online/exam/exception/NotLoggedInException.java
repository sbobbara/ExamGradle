package com.online.exam.exception;

@SuppressWarnings("serial")
public class NotLoggedInException extends RuntimeException{
	public NotLoggedInException(String msg) {
		super(msg);
	}
}