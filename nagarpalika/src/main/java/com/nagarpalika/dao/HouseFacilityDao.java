package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.HouseFacilityDetailModel;

public interface HouseFacilityDao {
	
	public int save(HouseFacilityDetailModel h);

	public HouseFacilityDetailModel findById(String id);
	
	public int findMax();

	public void delete(String id);

	public void update(HouseFacilityDetailModel h, String id);

	public List<HouseFacilityDetailModel> findAll();
	

}
