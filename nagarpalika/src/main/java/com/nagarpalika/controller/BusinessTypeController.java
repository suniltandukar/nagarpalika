package com.nagarpalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.BusinessTypeModel;
import com.nagarpalika.service.BusinessTypeService;

@Controller
@RequestMapping("/businesstype")
public class BusinessTypeController {
	
	@Autowired
	BusinessTypeService businessTypeService;
	
	@ModelAttribute
	public void modelattribute(Model model, @ModelAttribute("msg") String msg){
		List<BusinessTypeModel> list = businessTypeService.findAll();
		model.addAttribute("findAll", list);
		
		if(msg!=null){
			model.addAttribute("msg", msg);
		}
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String addNew(){
		
		return "settings/businesstype/insert";
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BusinessTypeModel d, RedirectAttributes model){
		String msg = "";
	
		int status = businessTypeService.save(d);
		if(status>0){
		msg = "Save Successful!";
		}
		else{
			msg = "Save Failed!";
		}
		model.addFlashAttribute("msg",msg);
		return "redirect:/businesstype/";
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable String id, Model model){
		BusinessTypeModel d = businessTypeService.findById(id);
		model.addAttribute("findById", d);
		return "settings/businesstype/edit";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes model){
		String msg = "";
		int status = businessTypeService.delete(id);
		if(status>0){
			msg = "Delete Successful!";
		}
		else{
			msg = "Delete Failed!";
		}
		model.addFlashAttribute("msg",msg);
		return "redirect:/businesstype/";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute BusinessTypeModel d, @PathVariable String id,RedirectAttributes model){
		String msg = "";
		int status = businessTypeService.update(d, id);
		if(status>0){
		msg = "Update Successful!";	
		}
		else{
			msg = "Update Failed!";
		}
		model.addFlashAttribute("msg", msg);
		return "redirect:/businesstype/";
	}


}
