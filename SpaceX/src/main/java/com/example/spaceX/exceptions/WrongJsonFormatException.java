package com.example.spaceX.exceptions;

import org.springframework.boot.configurationprocessor.json.JSONException;

public class WrongJsonFormatException extends JSONException{
	

	private static final long serialVersionUID = 1L;
	private String reason;

	public WrongJsonFormatException(String reason) {
		super(reason);
		this.reason=reason;
	}
	
	public String getReason() {
		return reason;
	}


}
