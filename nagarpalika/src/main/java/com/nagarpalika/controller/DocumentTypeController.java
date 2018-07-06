package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.model.DocumentTypeDetailModel;
import com.nagarpalika.service.DocumentTypeService;

@Controller
@RequestMapping("/documentType")
public class DocumentTypeController {
	
	@Autowired
	DocumentTypeService ds;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute DocumentTypeDetailModel d){
		try{
		//documentTypeDao.save(d);
			ds.save(d);
		}
		catch(Exception e){
			System.out.println(e);
			return "Save Failed!";
		}
		
		return "Save Successful!";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("dt",ds.getSpecificDocumentType(id));
		return "settings/idType/edit";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable String id, @ModelAttribute DocumentTypeDetailModel d){
		ds.update(d, id);
		return "Save Successful!";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		try {
			ds.delete(id);
		} catch (Exception e) {
			return "Delete Failed!";
		}
	 
		return "Delete Successful!";
	}

}
