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

import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.model.HouseRentDetailModel;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.HouseRentDetailService;

@Controller
@RequestMapping("/houseRent")
public class HouseRentDetailController {
	
	@Autowired
	HouseRentDetailService houseRentDetailService;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute HouseRentDetailModel h, @ModelAttribute("user") String user,BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseRentDetail");
			attributes.addFlashAttribute("hf",h);
			return model1;
		}
		h.setInputter(user);
		int save = houseRentDetailService.save(h);
		if (save > 0) {
			int max_value = houseRentDetailService.findMax();
			attributes.addFlashAttribute("msg", "Save Successful!");
			ModelAndView model1 = new ModelAndView("redirect:edit/" + max_value + "");
			return model1;
		} else {
			attributes.addFlashAttribute("msg", "Save Failed!");
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseRentDetail");
			return model1;
		}
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model) {
		HouseRentDetailModel houseRentDetail= houseRentDetailService.findById(id);
		
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("hd", houseRentDetail);
		model.addAttribute("msg", msg);
		return "houseRentDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute HouseRentDetailModel h,@ModelAttribute("user") String user, RedirectAttributes attributes){
		try{
			h.setInputter(user);
		houseRentDetailService.update(h, id);
		attributes.addFlashAttribute("msg", "Update Successful!");
		}
		catch(Exception e){
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Update Failed!");
		}
		return "redirect:/nav/viewHouseRentDetail";
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attributes)
	{
		try {
			houseRentDetailService.delete(id);
			attributes.addFlashAttribute("msg", "Delete Successful!");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Delete Failed!");
		}
		
		return "redirect:/nav/viewHouseRentDetail";
	}

}
