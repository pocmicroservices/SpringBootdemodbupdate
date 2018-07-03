package com.demo.apply.exception;

public class ErrorDetails {

	private String statusCode;
	private String type;
	private String message;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ErrorDetails(String statusCode,String type,String message)
	{
		super();
		this.statusCode=statusCode;
		this.type=type;
		this.message=message;
	}

}
