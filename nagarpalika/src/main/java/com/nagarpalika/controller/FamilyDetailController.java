package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;

@Controller
@RequestMapping("/familyDetail")
public class FamilyDetailController {
	@Autowired
	FamilyDetailDao familyDetailDao;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute FamilyDetailModel f){
		try{
		familyDetailDao.save(f);
		return "Save Successful!";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "Save Failed!";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("fd",familyDetailDao.getSpecificFamilyDetail(id));
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
