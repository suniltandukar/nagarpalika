package com.nagarpalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;
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
	public String insertHouseOwner(@ModelAttribute HouseOwnerDetailModel hm,RedirectAttributes attributes,@ModelAttribute OwnerDetailModel owner)
	{
		hhs.insertHouseOwner(hm);
		System.out.println(owner.getHouse_owner_id().size()+" list");
		
		for(int i=0; i<owner.getHouse_owner_id().size();i++){
		hhs.insertOwnerIdentity(owner,i);
		System.out.println("reached"+ i);
		}
		
		attributes.addFlashAttribute("ho",hm);
		attributes.addFlashAttribute("msg","Save Successful!");
		return "redirect:/nav/houseHoldDetail";
	}
	@RequestMapping(value="/edit/{id}")
	public String editHouseOwner(Model model,@PathVariable String id,RedirectAttributes attributes)
	{
	//	System.out.println(owner_identity_id);
		HouseOwnerDetailModel ho=hhs.editHouseOwner(id);
		List<OwnerDetailModel> ownerList=hhs.editOwnerDetail(id);
		/*model.addAttribute("ho",ho);*/
		attributes.addFlashAttribute("ho",ho);
		//attributes.addFlashAttribute("ownerList",ownerList);
		
		return "redirect:/nav/houseHoldDetail";
	}
	
	@RequestMapping(value="/update/{id}")
	public String updateHouseOwner(Model model, @PathVariable String id,@ModelAttribute HouseOwnerDetailModel hm, RedirectAttributes attr){
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
