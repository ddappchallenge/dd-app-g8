package com.ddth.challenge.shtp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.annotation.PostConstruct;

@ControllerAdvice
public class GlobalExceptionHandler {
	@PostConstruct
	public void start(){
		System.out.println("Start Global Exception handler");
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void handleAll(){
		System.out.println("Exception Handler");
	}

}
