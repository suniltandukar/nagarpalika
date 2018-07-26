
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.service.FamilyDetailService;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.RelationService;
import com.nagarpalika.service.UploadService;

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

	@Autowired
	UploadService uploadService;

	@RequestMapping(value = "/save")
	public String save(@RequestParam("files") MultipartFile file, @ModelAttribute FamilyDetailModel familyDetail,
			@ModelAttribute("user") String user, RedirectAttributes attributes, Model model) {
		String saveFileName = "";
		String fileLocation = "/usr/local/tomcat7/webapps/images/thimi"; // can
			//String fileLocation = "F:/check";																// be
																			// taken
																			// from
																			// database
		String house_owner_id = familyDetail.getHouseOwnerDetailModel().getHouse_owner_id();
		String relation_id = familyDetail.getRelationModel().getRelation();

		familyDetail.setInputter(user);
		int save_status = familyDetailService.save(familyDetail);

		int max_id = familyDetailService.findMax();
		familyDetail.setFamily_detail_id(max_id);
		int family_detail_id = familyDetail.getFamily_detail_id();

		if (save_status > 0) {
			if (!file.getOriginalFilename().isEmpty()) {
				saveFileName = house_owner_id + "FAM" + relation_id + ".jpg";
				uploadService.upload(fileLocation, saveFileName, file);
				attributes.addFlashAttribute("msga", "File Uploaded!");

			} else {
				attributes.addFlashAttribute("msga", "File Upload Failed!");

			}
			attributes.addAttribute("msg", "Save Successful!");
		} else {
			attributes.addAttribute("msg", "Save Failed!");
		}

		model.addAttribute("fd", familyDetail);

		return "redirect:/familyDetail/edit/" + family_detail_id + "";

	}

	@ModelAttribute
	public void addAttributes(@ModelAttribute("msg") String msg, Model model) {
		model.addAttribute("houseOwner", houseOwnerService.findAll());
		model.addAttribute("occupation", occupationService.findAll());
		model.addAttribute("relation", relationService.findAll());
		model.addAttribute("disablity", formDetailService.getDisableType());
			model.addAttribute("msg", msg);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		FamilyDetailModel familyDetailModel = familyDetailService.findById(id);
		model.addAttribute("fd", familyDetailModel);
		return "familyDetail/edit";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @ModelAttribute FamilyDetailModel f,
			@ModelAttribute("user") String user, RedirectAttributes attributes) {
		try {
			f.setInputter(user);
			familyDetailService.update(f, id);
			attributes.addFlashAttribute("msg", "Update Successful!");
			return "redirect:/nav/familyDetail";
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Update Failed!");
			return "redirect:/nav/familyDetail";
		}

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, RedirectAttributes attributes) {
		try {
			familyDetailService.delete(id);
			attributes.addFlashAttribute("msg", "Delete Successful!");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("msg", "Delete Failed!");
		}

		return "redirect:/nav/familyDetail";
	}

}
