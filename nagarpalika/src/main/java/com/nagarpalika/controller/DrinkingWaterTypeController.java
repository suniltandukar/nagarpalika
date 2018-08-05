package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.service.DrinkingWaterTypeService;

@Controller
@RequestMapping("/drinkingWater")
public class DrinkingWaterTypeController {
	
	@Autowired
	DrinkingWaterTypeService drinkingWaterTypeService;
	@RequestMapping(value="/save")
	public String save(@ModelAttribute DrinkingWaterTypeModel d, RedirectAttributes attributes){
		drinkingWaterTypeService.save(d);
		int max_value = drinkingWaterTypeService.findMax();
		attributes.addFlashAttribute("msg","Save Successful!");
		return "redirect:/drinkingWater/edit/"+max_value+"";
	}
	@ModelAttribute
	public void addAttributes(@ModelAttribute("msg") String msg, Model model){
		if(msg!=null){
			model.addAttribute("msg",msg);
		}
		
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id,Model model){
		System.out.println("id is"+id);
		DrinkingWaterTypeModel drinkingwater = drinkingWaterTypeService.findById(id);
		
		model.addAttribute("drinkingWaterType",drinkingWaterTypeService.findAll());
		model.addAttribute("drinkingwater", drinkingwater);
		return "settings/drinkingWater/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute DrinkingWaterTypeModel d, RedirectAttributes attributes){
		try{
			System.out.println("update id="+id);
			drinkingWaterTypeService.update(d, id);
		attributes.addFlashAttribute("msg", "Update Successful!");
		}
		catch(Exception e){
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Update Failed!");
		}
		return "redirect:/nav/drinkingWater";
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attributes)
	{
		try {
			drinkingWaterTypeService.delete(id);
			attributes.addFlashAttribute("msg", "Delete Successful!");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Delete Failed!");
		}
		
		return "redirect:/nav/drinkingWater";
	}
}
