package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
	model.addAttribute("ed",educationDetailDao.getEducationSpecificDetail(id));
		
		return "settings/educationDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id,@ModelAttribute EducationDetailModel e){
		educationDetailDao.update(e,id);
		System.out.println(e);
		return "Save Successful!";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		try {
			educationDetailDao.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}
	
	

}
