package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.HouseLandDetailModel;
import com.nagarpalika.service.HouseConstructionTypeService;
import com.nagarpalika.service.HouseOwnerService;

@Controller
@RequestMapping("/houseLand")
public class HouseLandDetailController {
	
	@Autowired
	HouseLandDetailDao houseLandDetailDao;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@Autowired
	HouseConstructionTypeService houseConstructionTypeService;
	
	@RequestMapping(value="/save")
	public String save(@ModelAttribute HouseLandDetailModel h, RedirectAttributes attributes){
			int save = houseLandDetailDao.save(h);
			if(save>0){
				int max_value = houseLandDetailDao.findMax();
				attributes.addFlashAttribute("msg","Save Successful!");
				return "redirect:edit/"+max_value+"";
			}
			else{
				attributes.addFlashAttribute("msg","Save Failed!");
				return "redirect:/nav/houseLandDetail";
			}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model){
		model.addAttribute("houseOwner",houseOwnerService.findAll());
		model.addAttribute("hd",houseLandDetailDao.findById(id));
		model.addAttribute("constructionType",houseConstructionTypeService.findAll());
		model.addAttribute("msg",msg);
		return "houseLandDetail/edit";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute HouseLandDetailModel h, RedirectAttributes attribute){
		try{
			houseLandDetailDao.update(h,id);
			attribute.addAttribute("msg","Update Successful!");
		return "redirect:/nav/houseLandDetail";
		}
		catch(Exception e){
			System.out.println(e);
			attribute.addAttribute("msg","Update Failed!");
			return "redirect:/houseLand/edit/"+id+"";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attribute)
	{
		try {
			houseLandDetailDao.delete(id);
			attribute.addAttribute("msg","Delete Successful!");
			return "redirect:/nav/houseLandDetail";
		} catch (Exception e) {
			attribute.addAttribute("msg","Delete Successful!");
			return "redirect:/nav/houseLandDetail";
		}
	}

}
