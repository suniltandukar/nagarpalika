package com.nagarpalika.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.dao.OperationDao;
import com.nagarpalika.dao.UserDao;
import com.nagarpalika.model.UserModel;




@JsonIgnoreProperties(ignoreUnknown = true)
@Controller
@SessionAttributes(value = { "userDetail", "systemdetail" })
public class HomeController {
	@Autowired
	private UserDao dao;

	@Autowired
	private OperationDao operationDao;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute(value="msg") String msg) {
		 String inputLine="";
		URL url=null;
		try {
			 url = new URL("http://202.70.78.243/thimihh/index.php/api/getJson");
			 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try{
		URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                yc.getInputStream()));
       
        while ((inputLine = in.readLine()) != null){ 
        	  
            System.out.println(inputLine);
         
            //System.out.println(split[0]);
            
        in.close();
        }
      
		}
		catch(Exception e){
			System.out.println(e);
		}
		  String[] string = inputLine.split("\\|");
          for(int i=0; i<string.length;i++){
        	  boolean even = checknum(i);
        	  if(even){
          		System.out.println(string[i]);
        	  }
        	  else{
        		  String[] values = string[i].split("^^");
        		  System.out.println(values[0]);
        	  }
         
          }
		model.addAttribute("msg",msg);
		/*logger.info("Home Controller is On");
		logger.debug("Debug Logger");
		logger.error("Error Debug");
		logger.trace("trace logger");*/
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
		UserModel userDetail = dao.getUserDetails(user);
		return userDetail;
		
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
	public boolean checknum(int num){
		double value = num%2;
		if(value==0){
			return true;
		}
		else{return false;}
	}
	
	
	@RequestMapping(value="/survey", produces="application/json", method=RequestMethod.POST)
	public @ResponseBody String survey( @RequestBody String requestFromMobile)
	{
		System.out.println("This is data from front" + requestFromMobile);
		try {
			JSONObject jsnobject = new JSONObject(requestFromMobile);
			System.out.println("This is house name" + jsnobject.getString("house"));

			JSONArray jsonArray = jsnobject.getJSONArray("locations");
			for (int i = 0; i < jsonArray.length(); i++) {
			    JSONObject explrObject = jsonArray.getJSONObject(i);
			    System.out.println("These are locations" + explrObject);
			}			

		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status","200");
			jsonObject.put("message","Successfully data is located to the database");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonArray.put(jsonObject);
		return jsonArray.toString();
		
	}
	
 
}
