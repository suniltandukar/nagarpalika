package com.nagarpalika.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseConstructionTypeModel;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.RelationModel;
import com.nagarpalika.service.RestService;

@RestController
@RequestMapping("/data")
public class RestSurveyController {
	 private static final String USER_AGENT = "Mozilla/5.0";
	 
	@Autowired
	RestService restService;
	
	@RequestMapping(value = "/getDynamicDatas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> dynamicDatas() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<OccupationModel> occupation_type = restService.getOccupation();
		List<EducationDetailModel> education_detail = restService.getEducation();
		List<DisableTypeModel> disabledtype =restService.getDisableType();
		List<RelationModel> relationtbl = restService.getRelation();
		List<HouseHoldDetailModel> house_owner_detail = restService.getHouseHoldDetail();
		List<FamilyDetailModel> family_detail = restService.getFamilyDetail();
		List<HouseConstructionTypeModel> house_construction_type = restService.getHouseConstruction();
		
		map.put("occupation_type", occupation_type);
		map.put("education_detail", education_detail);
		map.put("disabledtype", disabledtype);
		map.put("relationtbl", relationtbl);
		map.put("house_owner_detail", house_owner_detail);
		map.put("family_detail", family_detail);
		map.put("house_construction_type", house_construction_type);

		return map;
	}
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public void sms(){
		  try {
			  String params = "http://api.sparrowsms.com/v2/sms?token=X1PRVmYjS6hrHYDhMLew&from=Demo&to=9843182011&text=hello";
			 
		URL url = new URL(params);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		System.out.println(conn);
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "application/json");
		
		/*if (conn.getResponseCode() >= 300) {
			  // Something unexpected happened
			  System.out.println("Unexpected response from server");
			  System.out.println(conn.getResponseMessage());
			  System.out.println(conn.getResponseCode());
			  return; // Stop here
		}*/
		
		/*HashMap<String, String> map = smsdata();
		
		conn.setDoOutput(true);
		DataOutputStream out= new DataOutputStream(conn.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(map));
		out.flush();
		out.close();*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine=br.readLine())!=null){
			response.append(inputLine);
		}
		br.close();
		
		System.out.println(response.toString());
		

		
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch(MalformedURLException e) {

		e.printStackTrace();

	  } catch(IOException e) {

		e.printStackTrace();

	  }

		

	}
	
	public HashMap<String, String> smsdata(){
		String phoneno="9869718832";
		String text = "hello";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("token", "X1PRVmYjS6hrHYDhMLew");
		map.put("from", "Demo");
		map.put("to", phoneno);
		map.put("text", text);
		return map;
	}
	

}
