package com.nagarpalika.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.service.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	UploadService uploadService;
	
	@RequestMapping(value="/idupload")
	private String saveImage(@RequestParam("files") MultipartFile file,@RequestParam Map<String, String> requestParam, @ModelAttribute("user") String user, RedirectAttributes attributes) {
		String document_type = requestParam.get("document_type");
		String house_owner_id = requestParam.get("house_owner_id");
		String saveFileName=null;
		String fileLocation=null; 
		fileLocation="";
			if (!file.getOriginalFilename().isEmpty()) {
				saveFileName=document_type+house_owner_id+".jpg";
				fileLocation="F:/check"; //can be taken from database
				uploadService.upload(fileLocation, saveFileName, file);
				attributes.addAttribute("msg","Upload Successful");
			} else {
				attributes.addAttribute("msg","Please select file");
			}
	
		return "redirect:/nav/idupload";
	}
}
