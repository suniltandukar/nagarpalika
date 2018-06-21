package com.nagarpalika.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.dao.OperationDao;
import com.nagarpalika.dao.UserDao;
import com.nagarpalika.model.UserModel;




@Controller
@SessionAttributes(value = { "userDetail", "systemdetail" })
public class HomeController {
	@Autowired
	private UserDao dao;

	@Autowired
	private OperationDao operationDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute(value="msg") String msg) {
		
		String[] key={"Owner Id","Land and House ID","Family Id","Ownership Type","House Number","Land Unit","Land Size","Plot Num","Sheet Num","District","Municipality/ Village council","Ward Number","Moth Number","Kitta Number","Land Legacy Address","Land Current District","Land Current Municipality/ Village Council","Ward No","Tole","House Construction Type","Used Status","House Floor Count","Rentnted Floor Count","House Area Unit","House Area","Map Application Date","Map Approved Date","Construction Start Date","Construction Completion Date","Construction Completion Municipality/ Village Council","Completion Approved By","House Map Municipality/ Village Council","Inputter","Authorizer","Date And Time","Current Number"};
		String[] value={"house_owener_id","land_house_id","family_id","ownership_type","house_number","land_unit","land_size","plot_num","sheet_num","district_uni","mun_vc_uni","ward_no_uni","moth_num_uni","kitta_num_uni","land_legacy_address","land_current_district","land_current_mun_vc","ward_no","tole","house_construction_type","used_status","house_floor_count","rented_floor_count","house_area_unit","house_area","map_application_date","map_approved_date","construction_start_date","construction_completion_date","construction_completion_approval_date","completion_approved_by","house_map_prepared_by","inputter","authorizer","date_time","curr_number"};
		
		int j=0;
		for(int i=0;i<key.length;i++){
			
				System.out.println("<tr>");
				
			System.out.println("<td><h6><strong>"+key[i]+"</strong></h6> <input type='text' class='form-control' name='"+value[i]+"'></td>");
			System.out.println("<td><h6><strong>"+key[i+1]+"</strong></h6> <input type='text' class='form-control' name='"+value[i+1]+"'></td>");
			System.out.println("<td><h6><strong>"+key[i+2]+"</strong></h6> <input type='text' class='form-control' name='"+value[i+2]+"'></td>");
			
			System.out.println("</tr>");
			i=i+2;
			
		}
		
		model.addAttribute("msg",msg);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserModel user, ModelMap model, BindingResult result, RedirectAttributes attributes) {

		boolean status = dao.verifyUser(user);
		System.out.println(status+"fdsafasdfsdf");
		if (status) {
			UserModel userDetail = getUser(user);
			List<UserModel> systemdetail = operationDao.getSystemDetails();
			model.put("userDetail", userDetail);
			model.put("systemdetail", systemdetail);
			return "profile";
		} else {
			attributes.addFlashAttribute("msg","Invalid Login Credentials!");
			return "redirect:/";
		}

	}

	public UserModel getUser(UserModel user) {
		return dao.getUserDetails(user);
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value = "/{name}")
	public String pathDemo(@PathVariable String name) {
		System.out.println(name);
		return "index";
	}
	
}
