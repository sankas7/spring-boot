package com.learnspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class DepartmentResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<ErrorMessage> departmentException(DepartmentException departmentException,WebRequest request)
	{
		ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND, departmentException.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
}
