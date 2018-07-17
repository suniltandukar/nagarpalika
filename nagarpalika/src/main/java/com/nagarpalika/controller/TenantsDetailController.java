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
import com.nagarpalika.model.TenantDetailModel;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.TenantsDetailService;

@Controller
@RequestMapping("/tenants")
public class TenantsDetailController {
	
	@Autowired
	TenantsDetailService tenantsDetailService;
	
	@Autowired
	OccupationService occupationService;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute TenantDetailModel t, BindingResult result,@ModelAttribute("user") String user, RedirectAttributes attributes) {
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("redirect:/nav/tenantsDetail");
			attributes.addFlashAttribute("t",t);
			return model1;
		}
		t.setInputter(user);
		int save = tenantsDetailService.save(t);
		if (save > 0) {
			int max_value = tenantsDetailService.findMax();
			attributes.addFlashAttribute("msg", "Save Successful!");
			ModelAndView model1 = new ModelAndView("redirect:edit/" + max_value + "");
			return model1;
		} else {
			attributes.addFlashAttribute("msg", "Save Failed!");
			ModelAndView model1 = new ModelAndView("redirect:/nav/tenantsDetail");
			return model1;
		}
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model) {
		TenantDetailModel tenantsDetailModel= tenantsDetailService.findById(id);
		
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("t", tenantsDetailModel);
		model.addAttribute("occupation",occupationService.findAll());
		model.addAttribute("msg", msg);
		return "tenantsDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute TenantDetailModel t,@ModelAttribute("user") String user, RedirectAttributes attributes){
		try{
			t.setInputter(user);
			tenantsDetailService.update(t, id);
		attributes.addFlashAttribute("msg", "Update Successful!");
		}
		catch(Exception e){
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Update Failed!");
		}
		return "redirect:/nav/tenantsDetail";
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attributes)
	{
		try {
			tenantsDetailService.delete(id);
			attributes.addFlashAttribute("msg", "Delete Successful!");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Delete Failed!");
		}
		
		return "redirect:/nav/viewTenantsDetail";
	}

}
