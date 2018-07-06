package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.dao.OccupationDao;
import com.nagarpalika.model.OccupationModel;

@Controller
@RequestMapping("/occupation")
public class OccupationController {
	
	@Autowired
	OccupationDao occupationDao;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(OccupationModel o){
		try{
			occupationDao.save(o);
			
		}catch(Exception e){
			System.out.println(e);
			return "Save Failed!";
		}
		return "Save Successful!";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("o",occupationDao.getSpecificOccupationType(id));
		return "settings/occupationType/edit";
	}

	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id, @ModelAttribute OccupationModel o ){
		try{
		occupationDao.update(o, id);
		}
		catch(Exception e){
		return "Save Failed!";
		}
		return "Save Successful!";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		try {
			occupationDao.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}
}
