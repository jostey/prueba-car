package com.curso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.curso.exception.NotFoundException;

@ControllerAdvice(basePackages= "com.curso.controller")
public class ControllerExceptionAdvicer {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
	public Exception handlerNotFoundException(NotFoundException e) {
		return e;
	}
}
