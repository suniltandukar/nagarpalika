package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.service.HouseHoldService;
import com.nagarpalika.service.HouseOwnerService;

@Controller
@RequestMapping("/houseOwner")
public class HouseOwnerController {
	
	/*@RequestMapping(value="/", method = RequestMethod.POST)
	public String save(){
		return "";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String findAll(){
		return "";
	}*/
	
	@Autowired
	HouseOwnerService hhs;
	
	@RequestMapping(value="/insert")
	public String insertHouseOwner(@ModelAttribute HouseOwnerDetailModel hm,RedirectAttributes attributes)
	{
		hhs.insertHouseOwner(hm);
		attributes.addFlashAttribute("ho",hm);
		
		return "redirect:/nav/houseHoldDetail";
	}
	@RequestMapping(value="/edit/{id}")
	public String editHouseOwner(Model model,@PathVariable String id)
	{
		HouseOwnerDetailModel ho=hhs.editHouseOwner(id);
		model.addAttribute("ho",ho);
		return "houseHoldDetail/insert";
	}
	

}
