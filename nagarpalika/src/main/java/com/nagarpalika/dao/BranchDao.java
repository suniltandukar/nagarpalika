package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.BranchModel;


public interface BranchDao {
	public List<BranchModel> findAll();

	public void insertBranch(BranchModel bmodel);
}
