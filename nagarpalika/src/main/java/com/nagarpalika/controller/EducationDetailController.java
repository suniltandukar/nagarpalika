package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.EducationDetailModel;

@Controller
@RequestMapping("/educationDetail")
public class EducationDetailController {
	
	@Autowired
	EducationDetailDao educationDetailDao;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute EducationDetailModel e){
		educationDetailDao.save(e);
		System.out.println(e);
		return "Save Successful!";
	}

}
