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
	
	@RequestMapping(value = "/sms")
	public void sms(){
		  try {
		URL url = new URL("http://api.sparrowsms.com/v2/sms?token=LOBQN7ZX5MycjZUUnBIS&from=Demo&to=9869718832&text=hello");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

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

}
