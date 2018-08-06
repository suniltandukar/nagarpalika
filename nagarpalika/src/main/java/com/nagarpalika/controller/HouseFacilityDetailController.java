package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.service.DrinkingWaterTypeService;
import com.nagarpalika.service.HouseFacilityService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.RoadTypeService;
import com.nagarpalika.service.UploadService;

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
	
	@Autowired
	UploadService uploadService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("files") MultipartFile file,@ModelAttribute HouseFacilityDetailModel h, @ModelAttribute("user") String user,BindingResult result, RedirectAttributes attributes) {
		String saveFileName ="";
		String fileLocation="/usr/local/tomcat7/webapps/images/thimi"; //can be taken from database
		String house_owner_id = h.getHouseOwnerDetailModel().getHouse_owner_id();
		String house_land_id = h.getLand_house_id();
		
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseFacilityDetail");
			attributes.addFlashAttribute("hf",h);
			return model1;
		}
		h.setInputter(user);
		int save = houseFacilityService.save(h);
		if (save > 0) {
			if (!file.getOriginalFilename().isEmpty()) {
				saveFileName=house_owner_id+"HF"+house_land_id+".jpg";
				uploadService.upload(fileLocation, saveFileName, file);
				attributes.addFlashAttribute("msg", "Save Successful!");

			} else {
				attributes.addFlashAttribute("msg", "Save Failed!");

			}
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
	
	
	/*@ResponseBody
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET,produces="application/json")
	public HouseFacilityDetailModel edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model) {
		HouseFacilityDetailModel houseFacilityDetail= houseFacilityService.findById(id);
		
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("hd", houseFacilityDetail);
		model.addAttribute("drinkingWater",drinkingWaterTypeService.findAll());
		model.addAttribute("roadType",roadTypeService.findAll());
		model.addAttribute("msg", msg);
		return houseFacilityDetail;
	}
	*/
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute HouseFacilityDetailModel h,@ModelAttribute("user") String user, RedirectAttributes attributes){
		try{
			h.setInputter(user);
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
