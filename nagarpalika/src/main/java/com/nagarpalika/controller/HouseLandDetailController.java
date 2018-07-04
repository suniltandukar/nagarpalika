package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseLandDetailModel;

@Controller
@RequestMapping("/houseLand")
public class HouseLandDetailController {
	
	@Autowired
	HouseLandDetailDao houseLandDetailDao;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(@ModelAttribute HouseLandDetailModel h){
		try{
			houseLandDetailDao.save(h);
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
		model.addAttribute("hd",houseLandDetailDao.getSpecificHouseLand(id));
		return "houseLandDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id, @ModelAttribute HouseLandDetailModel h){
		try{
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
		} catch (Exception e) {
			return "Delete Failed!";
		}
		return "Delete Successful!";
	}

}
