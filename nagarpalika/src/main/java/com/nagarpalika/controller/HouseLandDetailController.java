package com.nagarpalika.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseLandDetailModel;
import com.nagarpalika.service.FamilyDetailService;
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

	@Autowired
	FamilyDetailService familyDetailService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute HouseLandDetailModel h, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseLandDetail");
			attributes.addFlashAttribute("hl",h);
			return model1;
		}
		int save = houseLandDetailDao.save(h);
		if (save > 0) {
			int max_value = houseLandDetailDao.findMax();
			attributes.addFlashAttribute("msg", "Save Successful!");
			ModelAndView model1 = new ModelAndView("redirect:edit/" + max_value + "");
			return model1;
		} else {
			attributes.addFlashAttribute("msg", "Save Failed!");
			ModelAndView model1 = new ModelAndView("redirect:/nav/houseLandDetail");
			return model1;
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute("msg") String msg, Model model) {
		HouseLandDetailModel houseLandDetail = houseLandDetailDao.findById(id);
		String house_owner_id = houseLandDetail.getHouseOwnerDetailModel().getHouse_owner_id();
		List<String> list = new ArrayList<String>();
		String options = "";
		List<FamilyDetailModel> familyDetail = familyDetailService.findByHouseOwnerId(house_owner_id);
		
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("hd", houseLandDetail);
		model.addAttribute("constructionType", houseConstructionTypeService.findAll());
		model.addAttribute("familyDetail",familyDetail);
		model.addAttribute("msg", msg);
		return "houseLandDetail/edit";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute HouseLandDetailModel h,
			RedirectAttributes attribute) {
		try {
			houseLandDetailDao.update(h, id);
			attribute.addAttribute("msg", "Update Successful!");
			return "redirect:/nav/houseLandDetail";
		} catch (Exception e) {
			System.out.println(e);
			attribute.addAttribute("msg", "Update Failed!");
			return "redirect:/houseLand/edit/" + id + "";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attribute) {
		try {
			houseLandDetailDao.delete(id);
			attribute.addAttribute("msg", "Delete Successful!");
			return "redirect:/nav/houseLandDetail";
		} catch (Exception e) {
			attribute.addAttribute("msg", "Delete Successful!");
			return "redirect:/nav/houseLandDetail";
		}
	}

	@RequestMapping(value = "/findFamilyId", method = RequestMethod.POST)
	@ResponseBody
	public String findFamilyId(@ModelAttribute FamilyDetailModel familyDetailModel) {
		String house_owner_id = familyDetailModel.getHouseOwnerDetailModel().getHouse_owner_id();
		List<String> list = new ArrayList<String>();
		String options = "";

		List<FamilyDetailModel> familyDetail = familyDetailService.findByHouseOwnerId(house_owner_id);
		if (familyDetail.size() > 0) {
			for (int i = 0; i < familyDetail.size(); i++) {
				int family_detail_id = familyDetail.get(i).getFamily_detail_id();
				String fname = familyDetail.get(i).getFname();

				options = "<option value='" + family_detail_id + "'>" + family_detail_id + "/" + fname + "</option>";
				list.add(options);
			}
		}
		else{
			options="<option value=''>Select Family Id</option>";
			list.add(options);
		}

		return "" + list + "";

	}

}
