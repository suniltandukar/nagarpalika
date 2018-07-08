package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.service.HouseHoldService;
import com.nagarpalika.service.HouseOwnerService;

@Controller
@RequestMapping("/houseOwner")
public class HouseOwnerController {
	
	/*@RequestMapping(value="/", method = RequestMethod.POST)
	public String save(){
		return "";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String findAll(){
		return "";
	}*/
	
	@Autowired
	HouseOwnerService hhs;
	
	@RequestMapping(value="/insert")
	public String insertHouseOwner(@ModelAttribute HouseOwnerDetailModel hm)
	{
		hhs.insertHouseOwner(hm);
		return "";
	}
	

}
