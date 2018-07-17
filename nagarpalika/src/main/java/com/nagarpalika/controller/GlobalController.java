package com.nagarpalika.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nagarpalika.model.UserModel;

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e){
		System.out.println("unknown error occured "+e);
		return "Exception";
	}
	 @ModelAttribute("user")
	    public String sessionUser(HttpSession session) {
		 String user="";
		 UserModel userModel = (UserModel)session.getAttribute("userDetail");
		 if(userModel==null){
			 return "index";
		 }
		 else{
		 user=userModel.getUsername();
		 }
	        return user;
	    }

}
