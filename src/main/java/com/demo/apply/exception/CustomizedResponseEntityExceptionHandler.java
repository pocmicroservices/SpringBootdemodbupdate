package com.demo.apply.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails("15000",ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(ApplyCardException.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(ApplyCardException ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(ex.getErrorCode(),ex.getType(),ex.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.PARTIAL_CONTENT);
	}
	@ExceptionHandler(InvalidCardApplicationDataException.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(InvalidCardApplicationDataException ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(ex.getErrorCode(),ex.getType(),ex.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}

