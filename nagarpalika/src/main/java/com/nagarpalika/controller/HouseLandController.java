package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarpalika.dao.HouseLandDao;
import com.nagarpalika.model.HouseLandDetailModel;

@Controller
@RequestMapping("/houseLand")
public class HouseLandController {
	
	@Autowired
	HouseLandDao houseLandDao;
	
	@RequestMapping(value="/insertHouseLand", method = RequestMethod.POST)
	public String insertHouseLand(Model model,@ModelAttribute HouseLandDetailModel hld )
	{
		houseLandDao.insertHouseLand(hld);
		return "";
	}
}
