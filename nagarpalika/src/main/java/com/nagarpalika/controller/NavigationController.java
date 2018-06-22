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
	@RequestMapping(value = "/familyDetail")
	public String familyDetail(){
		return "familyDetail/insert";
	}
	
	@RequestMapping(value = "/houseFacilityDetail")
	public String houseFacilityDetail(){
		return "houseFacilityDetail/insert";
	}
	
	@RequestMapping(value = "/houseHoldDetail")
	public String houseHoldDetail(){
		return "houseHoldDetail/insert";
	}
	
	@RequestMapping(value = "/houseLandDetail")
	public String houseLandDetail(){
		return "houseLandDetail/insert";
	}
	

	@RequestMapping(value = "/houseRentDetail")
	public String houseRentDetail(){
		return "houseRentDetail/insert";
	}
	
	
	//settings
	
	@RequestMapping(value = "/educationDetail")
	public String educationDetail(){
		return "settings/educationDetail/insert";
	}

	@RequestMapping(value = "/idType")
	public String idType(){
		return "settings/idType/insert";
	}
	
	@RequestMapping(value = "/occupationList")
	public String occupationList(){
		return "settings/occupationList/insert";
	}
	
	@RequestMapping(value = "/occupationType")
	public String occupationType(){
		return "settings/occupationType/insert";
	}
}
