package com.nagarpalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;
import com.nagarpalika.model.OwnerIdentityDetailModel;
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
	public String insertHouseOwner(@ModelAttribute HouseOwnerDetailModel hm,@ModelAttribute("user") String user,RedirectAttributes attributes)
	{
		hm.setInputter(user);
		int save_status = hhs.insertHouseOwner(hm);
		int size = hm.getOwnerIdentityDetailModel().getId_number().size();
		for(int i=0;i<size;i++){
		hhs.insertOwnerIdentity(hm,i);
		System.out.println("reached"+ i);
		}
		
		if(save_status>0){
			attributes.addFlashAttribute("msg","Save Successful!");
			return "redirect:edit/"+hm.getHouse_owner_id()+"";
		}
		else{
			attributes.addFlashAttribute("msg","Save Failed!");
			return "redirect:/nav/houseHoldDetail";
		}
		
		
	}
	@RequestMapping(value="/edit/{id}")
	public String editHouseOwner(Model model,@PathVariable String id)
	{
		
		System.out.println("house owner id"+id);
		HouseOwnerDetailModel ho=hhs.editHouseOwner(id);
		model.addAttribute("ho",ho);
		
		List<OwnerDetailModel> ownerList=hhs.findById(id);
		model.addAttribute("ownerList",ownerList);
		
		return "houseHoldDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}")
	public String updateHouseOwner(Model model, @PathVariable String id,@ModelAttribute HouseOwnerDetailModel hm,@ModelAttribute("user") String user, RedirectAttributes attr){
		hm.setInputter(user);
		hhs.updateHouseOwner(id,hm);
		attr.addFlashAttribute("msg","Update Successful!");
		return "redirect:/nav/viewHouseHoldDetail";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteHouseOwner(Model model, @PathVariable String id){
		System.out.println("deleter");
		hhs.deleteHouseOwner(id);
		return "redirect:/nav/viewHouseHoldDetail";
	}
	
	

}
