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
		
		/*String[] key={"Id Type","Description","Record Status","Inputter","Authorizer","date and Time","Current Number"};
		String[] value={"id_type","description","record_status","inputter","authorizer","date_time","curr_number"};
		
		int j=0;
		for(int i=0;i<key.length;i++){
			
				System.out.println("<tr>");
				
			System.out.println("<td><h6><strong>"+key[i]+"</strong></h6> <input type='text' class='form-control' name='"+value[i]+"'></td>");
			System.out.println("<td><h6><strong>"+key[i+1]+"</strong></h6> <input type='text' class='form-control' name='"+value[i+1]+"'></td>");
			System.out.println("<td><h6><strong>"+key[i+2]+"</strong></h6> <input type='text' class='form-control' name='"+value[i+2]+"'></td>");
			
			System.out.println("</tr>");
			i=i+2;
			
		}*/
		
		model.addAttribute("msg",msg);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserModel user, ModelMap model, BindingResult result, RedirectAttributes attributes) {

		boolean status = dao.verifyUser(user);
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
