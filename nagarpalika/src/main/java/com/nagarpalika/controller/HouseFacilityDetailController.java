package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.service.DrinkingWaterTypeService;
import com.nagarpalika.service.HouseFacilityService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.RoadTypeService;

@Controller
@RequestMapping("/houseFacility")
public class HouseFacilityDetailController {
	@Autowired
	HouseFacilityService houseFacilityService;
	@Autowired
	HouseOwnerService houseOwnerService;
	@Autowired
	DrinkingWaterTypeService drinkingWaterTypeService;
	@Autowired
	RoadTypeService roadTypeService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute HouseFacilityDetailModel h, BindingResult result, RedirectAttributes attributes) {
		System.out.println("reached");
		if(result.hasErrors()){
			System.out.println("got error");
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseFacilityDetail");
			attributes.addFlashAttribute("hf",h);
			return model1;
		}
		int save = houseFacilityService.save(h);
		if (save > 0) {
			int max_value = houseFacilityService.findMax();
			attributes.addFlashAttribute("msg", "Save Successful!");
			ModelAndView model1 = new ModelAndView("redirect:edit/" + max_value + "");
			return model1;
		} else {
			attributes.addFlashAttribute("msg", "Save Failed!");
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseFacilityDetail");
			return model1;
		}
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model) {
		HouseFacilityDetailModel houseFacilityDetail= houseFacilityService.findById(id);
		
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("hd", houseFacilityDetail);
		model.addAttribute("drinkingWater",drinkingWaterTypeService.findAll());
		model.addAttribute("roadType",roadTypeService.findAll());
		model.addAttribute("msg", msg);
		return "houseFacilityDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute HouseFacilityDetailModel h, RedirectAttributes attributes){
		try{
		houseFacilityService.update(h, id);
		attributes.addFlashAttribute("msg", "Update Successful!");
		}
		catch(Exception e){
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Update Failed!");
		}
		return "redirect:/nav/viewHouseFacilityDetail";
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attributes)
	{
		try {
			houseFacilityService.delete(id);
			attributes.addFlashAttribute("msg", "Delete Successful!");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Delete Failed!");
		}
		
		return "redirect:/nav/viewHouseFacilityDetail";
	}
}
