package com.nagarpalika.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.UploadService;

@Controller
@RequestMapping("/houseOwner")
public class HouseOwnerController {

	@Autowired
	HouseOwnerService hhs;

	@Autowired
	UploadService uploadService;

	@Autowired
	EducationDetailDao educationDetailDao;

	@Autowired
	OccupationService occupationService;

	@Autowired
	FormDetailService formDetailService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertHouseOwner(@RequestParam("files") MultipartFile file, @Valid @ModelAttribute HouseOwnerDetailModel hm,
			@ModelAttribute("user") String user, RedirectAttributes attributes, BindingResult result) {
		if(result.hasErrors()){
			System.out.println("errors found");
			
			return "redirect:/nav/houseHoldDetail";
		}
		String saveFileName = "";
		String fileLocation = "/usr/local/tomcat7/webapps/images/thimi"; // can be taken from database

		// setting inputter from session
		hm.setInputter(user);
		// insert owner detail
		int save_status = hhs.insertHouseOwner(hm);
		// insert identity detail
		int size = hm.getOwnerIdentityDetailModel().getId_number().size();
		for (int i = 0; i < size; i++) {
			hhs.insertOwnerIdentity(hm, i);
			String id_type = hm.getOwnerIdentityDetailModel().getId_type().get(i);
			String owner_id = hm.getHouse_owner_id();

			// uploading files
			if (!file.getOriginalFilename().isEmpty()) {
				saveFileName = owner_id + "ID" + id_type + ".jpg";
				uploadService.upload(fileLocation, saveFileName, file);
				attributes.addFlashAttribute("msg", "Save Successful!");
			} else {
				attributes.addFlashAttribute("msg", "Save Failed!");

			}
			System.out.println("reached" + i);
		}

		if (save_status > 0) {
			attributes.addFlashAttribute("msg", "Save Successful!");
			return "redirect:edit/" + hm.getHouse_owner_id() + "";
		} else {
			attributes.addFlashAttribute("msg", "Save Failed!");
			return "redirect:/nav/houseHoldDetail";
		}

	}

	@RequestMapping(value = "/edit/{id}")
	public String editHouseOwner(Model model, @PathVariable String id) {

		System.out.println("house owner id" + id);
		HouseOwnerDetailModel ho = hhs.editHouseOwner(id);
		model.addAttribute("ho", ho);

		List<OwnerDetailModel> ownerList = hhs.findById(id);
		model.addAttribute("edu", educationDetailDao.getEducationDetail());
		model.addAttribute("occupation", occupationService.findAll());
		model.addAttribute("disablity", formDetailService.getDisableType());
		model.addAttribute("ownerList", ownerList);

		return "houseHoldDetail/edit";
	}

	@RequestMapping(value = "/update/{id}")
	public String updateHouseOwner(Model model, @PathVariable String id, @ModelAttribute HouseOwnerDetailModel hm,
			@ModelAttribute("user") String user, RedirectAttributes attr) {
		hm.setInputter(user);
		hhs.updateHouseOwner(id, hm);
		attr.addFlashAttribute("msg", "Update Successful!");
		return "redirect:/nav/viewHouseHoldDetail";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteHouseOwner(Model model, @PathVariable String id) {
		System.out.println("deleter");
		hhs.deleteHouseOwner(id);
		return "redirect:/nav/viewHouseHoldDetail";
	}

}
