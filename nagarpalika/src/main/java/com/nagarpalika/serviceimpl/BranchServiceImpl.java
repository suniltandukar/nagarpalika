package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;
import com.nagarpalika.service.BranchService;

public class BranchServiceImpl implements BranchService{
	@Autowired
	BranchDao branchDao;

	public List<BranchModel> getBranches() {
		
		return branchDao.findAll();
	}

}
