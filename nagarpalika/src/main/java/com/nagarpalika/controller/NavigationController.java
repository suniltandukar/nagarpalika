package com.nagarpalika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	
	@RequestMapping(value = "/houseOwnerDetail")
	public String houseOwnerDetail(){
		return "form/houseOwnerDetail";
	}

}
