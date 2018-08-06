package com.nagarpalika.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.service.HouseOwnerService;

@Controller
@RequestMapping("/survey_data")
public class SurveryController {
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@ResponseBody
	@RequestMapping(value = "/getdatas")
	public ArrayList<HouseHoldDetailModel> survey_data(){
		System.out.println("got it man");
		List<HouseHoldDetailModel> array = houseOwnerService.findAll();
		return (ArrayList<HouseHoldDetailModel>) array;
	}
}
