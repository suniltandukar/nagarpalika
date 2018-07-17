package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.service.OccupationService;

@Controller
@RequestMapping("/occupation")
public class OccupationController {
	
	@Autowired
	OccupationService occupationService;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(OccupationModel o, @ModelAttribute("user") String user){
		o.setInputter(user);
			occupationService.save(o);
		return "Save Successful!";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("o",occupationService.findById(id));
		return "settings/occupationType/edit";
	}

	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id, @ModelAttribute OccupationModel o,@ModelAttribute("user") String user ){
		try{
			o.setInputter(user);
		occupationService.update(o, id);
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
			occupationService.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}
}
