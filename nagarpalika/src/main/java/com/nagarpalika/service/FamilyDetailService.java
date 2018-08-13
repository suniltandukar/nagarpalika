package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.FamilyDetailModel;

public interface FamilyDetailService {
	public List<FamilyDetailModel> findAll();
	
	public int save(FamilyDetailModel f);

	public List<FamilyDetailModel> getFamilyDetail();

	public FamilyDetailModel findById(String id);

	public void update(FamilyDetailModel f, String id);

	public void delete(String id);
	
	public int findMax();
	
	public List<FamilyDetailModel> findByHouseOwnerId(String id);

}
