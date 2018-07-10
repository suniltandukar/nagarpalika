
package com.nagarpalika.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.service.FamilyDetailService;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.RelationService;

@Controller
@RequestMapping("/familyDetail")
public class FamilyDetailController {
	@Autowired
	FamilyDetailService familyDetailService;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@Autowired
	OccupationService occupationService;
	
	@Autowired
	RelationService relationService;
	
	@Autowired
	FormDetailService formDetailService;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public ModelAndView save(@ModelAttribute FamilyDetailModel familyDetail, BindingResult result){
		
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("familyDetail/insert");
			return model1;
		}
		familyDetailService.save(familyDetail);
		familyDetail.setFamily_detail_id(familyDetailService.findMax());
		int family_detail_id = familyDetail.getFamily_detail_id();
		ModelAndView model1 = new ModelAndView(new RedirectView("edit/"+family_detail_id+""));
		model1.addObject("fd", familyDetail);
		
		return model1;
		
	}
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("houseOwner",houseOwnerService.findAll());
		model.addAttribute("occupation",occupationService.findAll());
		model.addAttribute("relation",relationService.findAll());
		model.addAttribute("disablity",formDetailService.getDisableType());
		
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		System.out.println("id is"+id);
		model.addAttribute("fd",familyDetailService.findById(id));
		return "familyDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute FamilyDetailModel f, RedirectAttributes attributes){
		try{
		familyDetailService.update(f, id);
		attributes.addFlashAttribute("msg", "Update Successful!");
		return "redirect:/nav/familyDetail";
		}
		catch(Exception e){
			attributes.addFlashAttribute("msg", "Update Failed!");
			return "redirect:/nav/familyDetail";
		}
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		try {
			familyDetailService.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}

}
