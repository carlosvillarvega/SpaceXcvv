package com.example.spaceX.exceptions;

import java.net.URISyntaxException;

public class WrongURIException extends URISyntaxException {

	private static final long serialVersionUID = 1L;
	private String input;
	private String reason;
	
	public WrongURIException(String input, String reason) {
		super(input, reason);
		this.input=input;
		this.reason=reason;
	}

	public String getInput() {
		return input;
	}

	public String getReason() {
		return reason;
	}

}
