package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.BranchModel;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.RelationService;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	@Autowired
	EducationDetailDao educationDetailDao;
	
	@Autowired
	DocumentTypeDao documentTypeDao;	
	
	@Autowired
	OccupationService occupationService;
	
	@Autowired
	FamilyDetailDao familyDetailDao;
	
	@Autowired
	FormDetailService formDetailService;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	RelationService relationService;
	
	@Autowired
	HouseOwnerService houseOwnerService;
	
	@RequestMapping(value = "/houseOwnerDetail")
	public String houseOwnerDetail(){
		return "form/houseOwnerDetail";
	}
	@RequestMapping(value = "/familyDetail")
	public String familyDetail(Model model){
		model.addAttribute("houseOwner",houseOwnerService.findAll());
		model.addAttribute("occupation",occupationService.findAll());
		model.addAttribute("relation",relationService.findAll());
		model.addAttribute("disablity",formDetailService.getDisableType());
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
		model.addAttribute("occupation", occupationService.findAll());
		return "settings/occupationType/insert";
	}
	
	@RequestMapping(value="/branch")
	public String viewBranch(Model model,@ModelAttribute("bmedit") BranchModel bm)
	{
		model.addAttribute("bm",branchDao.findAll());
		model.addAttribute("bmedit",bm);
		return "settings/branch/insert";
	}
	
	
	/*@RequestMapping(value="/")
	public String (Model model)
	{
		
		return "";
	}*/
}
