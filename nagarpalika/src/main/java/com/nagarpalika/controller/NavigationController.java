package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.dao.OccupationDao;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	@Autowired
	EducationDetailDao educationDetailDao;
	
	@Autowired
	DocumentTypeDao documentTypeDao;	
	
	@Autowired
	OccupationDao occupationDao;
	
	@RequestMapping(value = "/houseOwnerDetail")
	public String houseOwnerDetail(){
		return "form/houseOwnerDetail";
	}
	@RequestMapping(value = "/familyDetail")
	public String familyDetail(){
		return "familyDetail/insert";
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
		model.addAttribute("occupation", occupationDao.getOccupation());
		return "settings/occupationType/insert";
	}
}
