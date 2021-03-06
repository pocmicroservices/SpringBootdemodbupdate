package com.demo.apply.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class ApplyCardException extends RuntimeException {

	private String errorCode;
	private String type;
	private String message;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
	

	public ApplyCardException(String errorCode,String type,String message){
		super();
		this.errorCode=errorCode;
		this.type=type;
		this.message=message;
	}
	
	public ApplyCardException(String exception){
		super(exception);
	}
}
