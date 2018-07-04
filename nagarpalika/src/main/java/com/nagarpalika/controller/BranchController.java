package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;

@Controller
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	BranchDao branchDao;
	
	@RequestMapping("/insert")
	public String insertBranch(@ModelAttribute BranchModel bmodel)
	{
		
		return "";
	}

}
