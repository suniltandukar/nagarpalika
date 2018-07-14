package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.service.DrinkingWaterTypeService;

@Controller
@RequestMapping("/drinkingWater")
public class DrinkingWaterTypeController {
	
	@Autowired
	DrinkingWaterTypeService drinkingWaterTypeService;
	@RequestMapping(value="/save")
	public String save(@ModelAttribute DrinkingWaterTypeModel d){
		drinkingWaterTypeService.save(d);
		int max_value = drinkingWaterTypeService.findMax();
		return "redirect:/drinkingWater/edit/"+max_value+"";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id,Model model){
		drinkingWaterTypeService.findById(id);
		return "settings/drinkingWater/edit";
	}
}
