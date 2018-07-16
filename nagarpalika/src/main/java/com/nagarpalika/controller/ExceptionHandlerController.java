package com.nagarpalika.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e){
		System.out.println("unknown error occured "+e);
		return "Exception";
	}

}
