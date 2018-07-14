package com.nagarpalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.BranchModel;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseLandDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.service.DrinkingWaterTypeService;
import com.nagarpalika.service.FormDetailService;
import com.nagarpalika.service.HouseConstructionTypeService;
import com.nagarpalika.service.HouseFacilityService;
import com.nagarpalika.service.HouseOwnerService;
import com.nagarpalika.service.OccupationService;
import com.nagarpalika.service.RelationService;
import com.nagarpalika.service.RoadTypeService;

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
	
	@Autowired
	HouseConstructionTypeService houseConstructionTypeService;
	
	@Autowired
	HouseLandDetailDao houseLandDetailDao;
	
	@Autowired
	DrinkingWaterTypeService drinkingWaterTypeService;
	
	@Autowired 
	RoadTypeService roadTypeService;
	
	@Autowired
	HouseFacilityService houseFacilityService;
	
	@RequestMapping(value = "/houseOwnerDetail")
	public String houseOwnerDetail(){
		return "form/houseOwnerDetail";
	}
	
	@ModelAttribute
	public void getAttribute(Model model, @ModelAttribute("msg") String msg){
		if(msg!=null){
		model.addAttribute("msg",msg);
		}
		model.addAttribute("houseOwner",houseOwnerService.findAll());
	}
	@RequestMapping(value = "/familyDetail")
	public String familyDetail(Model model){
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
	public String houseFacilityDetail(Model model){
		model.addAttribute("drinkingWater",drinkingWaterTypeService.findAll());
		model.addAttribute("roadType",roadTypeService.findAll());
		return "houseFacilityDetail/insert";
	}
	
	@RequestMapping(value = "/viewHouseFacilityDetail")
	public String viewHouseFacilityDetail(Model model){
		model.addAttribute("houseFacility",houseFacilityService.findAll());
		return "houseFacilityDetail/view";
	}
	
	@RequestMapping(value = "/houseHoldDetail")
	public String houseHoldDetail(Model model, @ModelAttribute("ho") HouseOwnerDetailModel hm){
		model.addAttribute("edu",educationDetailDao.getEducationDetail());
		model.addAttribute("ho",hm);
		return "houseHoldDetail/insert";
	}
	
	@RequestMapping(value = "/houseLandDetail")
	public String houseLandDetail(Model model){
		model.addAttribute("constructionType",houseConstructionTypeService.findAll());
		return "houseLandDetail/insert";
	}
	@RequestMapping(value = "/viewHouseLandDetail")
	public String viewHouseLandDetail(Model model){
		List<HouseLandDetailModel> houseLandDetail = houseLandDetailDao.findAll(); 
		model.addAttribute("houseLandDetail", houseLandDetail);
		return "houseLandDetail/view";
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
	
	@RequestMapping(value="/viewHouseHoldDetail")
	public String viewHouseHoldDetail(Model model)
	{
		List<HouseHoldDetailModel> list=houseOwnerService.findAll();
		model.addAttribute("list",list);
		return "houseHoldDetail/view";
	}
	

	
	@RequestMapping(value="/drinkingWater")
	public String drinkingWater(Model model)
	{
		model.addAttribute("drinkingWaterType",drinkingWaterTypeService.findAll());
		return "settings/drinkingWater/insert";
	}
}
