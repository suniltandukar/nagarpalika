package com.nagarpalika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;

@Controller
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	BranchDao branchDao;
	
	@RequestMapping("/save")
	public String insertBranch(@ModelAttribute BranchModel bmodel)
	{
		try{
		branchDao.insertBranch(bmodel);
		
		}
		catch(Exception e)
		{
			System.out.println("branchinsert error");
		}
		return "settings/branch/insert";
	}
	
	@RequestMapping("/edit/{branch_id}")
	public String editBranch(@PathVariable String branch_id,Model model,RedirectAttributes attributes)
	{
		BranchModel bmodel=branchDao.editBranch(branch_id);
		attributes.addFlashAttribute("bmedit",bmodel);
		return "redirect:/nav/branch";
	}
	
	@RequestMapping("/update/{branch_id}")
	public String updateBranch(@PathVariable String branch_id, @ModelAttribute BranchModel bm)
	{
		branchDao.updateBranch(branch_id,bm);
		return "redirect:/nav/branch";
		
	}

}
