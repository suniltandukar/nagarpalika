package com.nagarpalika.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.RelationModel;
import com.nagarpalika.service.RelationService;

@Controller
@RequestMapping("/relation")
public class RelationController {
	
	@Autowired
	RelationService relationService; 
	
	@ModelAttribute
	public void modelattribute(Model model, @ModelAttribute("msg") String msg){
		List<RelationModel> list = relationService.findAll();
		model.addAttribute("findAll", list);
		
		if(msg!=null){
			model.addAttribute("msg", msg);
		}
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String addNew(){
		
		return "settings/relation/insert";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute RelationModel r, RedirectAttributes model){
		String msg = "";
	
		int status = relationService.save(r);
		if(status>0){
		msg = "Save Successful!";
		}
		else{
			msg = "Save Failed!";
		}
		model.addFlashAttribute("msg",msg);
		return "redirect:/relation/";
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable String id, Model model){
		RelationModel r = relationService.findById(id);
		model.addAttribute("findById", r);
		return "settings/relation/edit";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes model){
		String msg = "";
		int status = relationService.delete(id);
		if(status>0){
			msg = "Delete Successful!";
		}
		else{
			msg = "Delete Failed!";
		}
		model.addFlashAttribute("msg",msg);
		return "redirect:/relation/";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute RelationModel r, @PathVariable String id,RedirectAttributes model){
		String msg = "";
		int status = relationService.update(r, id);
		if(status>0){
		msg = "Update Successful!";	
		}
		else{
			msg = "Update Failed!";
		}
		model.addFlashAttribute("msg", msg);
		return "redirect:/relation/";
	}

}
