package com.nagarpalika.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.RelationService;

@Controller
@RequestMapping("/familyDetail")
public class FamilyDetailController {
	@Autowired
	FamilyDetailDao familyDetailDao;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@Autowired
	OccupationService occupationService;
	
	@Autowired
	RelationService relationService;
	
	@Autowired
	FormDetailService formDetailService;
	
	@RequestMapping(value="/save")
	public ModelAndView save(@ModelAttribute FamilyDetailModel f, BindingResult result){
		
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("familyDetail/insert");
			return model1;
		}
		
		familyDetailDao.save(f);
		ModelAndView model1 = new ModelAndView("");
		return model1;
		
	
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("houseOwner",houseOwnerService.findAll());
		model.addAttribute("occupation",occupationService.findAll());
		model.addAttribute("relation",relationService.findAll());
		model.addAttribute("disablity",formDetailService.getDisableType());
		model.addAttribute("fd",familyDetailDao.findById(id));
		return "familyDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id, @ModelAttribute FamilyDetailModel f){
		try{
		familyDetailDao.update(f, id);
		return "Save Successful!";
		}
		catch(Exception e){
		return "Save Unsuccessful!";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		try {
			familyDetailDao.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}

}
