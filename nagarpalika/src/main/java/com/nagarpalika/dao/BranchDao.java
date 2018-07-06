package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.BranchModel;


public interface BranchDao {
	public List<BranchModel> getBranches();

	public void insertBranch(BranchModel bmodel);

	public BranchModel editBranch(String branch_id);

	public void updateBranch(String branch_id, BranchModel bm);
}
