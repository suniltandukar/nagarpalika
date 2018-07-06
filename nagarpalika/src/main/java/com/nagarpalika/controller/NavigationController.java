package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.dao.OccupationDao;
import com.nagarpalika.service.FormDetailService;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	@Autowired
	EducationDetailDao educationDetailDao;
	
	@Autowired
	DocumentTypeDao documentTypeDao;	
	
	@Autowired
	OccupationDao occupationDao;
	
	@Autowired
	FamilyDetailDao familyDetailDao;
	
	@Autowired
	FormDetailService formDetailService;
	
	@RequestMapping(value = "/houseOwnerDetail")
	public String houseOwnerDetail(){
		return "form/houseOwnerDetail";
	}
	@RequestMapping(value = "/familyDetail")
	public String familyDetail(Model model){
		
		model.addAttribute("disablity",formDetailService.getDisableType());
		model.addAttribute("occupation",occupationDao.findAll());
		return "familyDetail/insert";
	}
	
	@RequestMapping(value = "/viewFamilyDetail")
	public String viewFamilyDetail(Model model){
		model.addAttribute("familyDetail", familyDetailDao.getFamilyDetail());
		return "familyDetail/view";
	}
	
	@RequestMapping(value = "/houseFacilityDetail")
	public String houseFacilityDetail(){
		return "houseFacilityDetail/insert";
	}
	
	@RequestMapping(value = "/houseHoldDetail")
	public String houseHoldDetail(){
		return "houseHoldDetail/insert";
	}
	
	@RequestMapping(value = "/houseLandDetail")
	public String houseLandDetail(){
		return "houseLandDetail/insert";
	}
	

	@RequestMapping(value = "/houseRentDetail")
	public String houseRentDetail(){
		return "houseRentDetail/insert";
	}
	
	
	//settings
	
	@RequestMapping(value = "/educationDetail")
	public String educationDetail(Model model){
		System.out.println(educationDetailDao.getEducationDetail());
		model.addAttribute("educationDetail",educationDetailDao.getEducationDetail());
		return "settings/educationDetail/insert";
	}

	@RequestMapping(value = "/idType")
	public String idType(Model model){
		model.addAttribute("documentType",documentTypeDao.getDocumentType());
		return "settings/idType/insert";
	}
	
	@RequestMapping(value = "/occupationType")
	public String occupationType(Model model){
		model.addAttribute("occupation", occupationDao.findAll());
		return "settings/occupationType/insert";
	}
}
