package com.example.speakingclock.exception;

public class InvalidTimeFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidTimeFormatException(String message) {
		super(message);
	}
}