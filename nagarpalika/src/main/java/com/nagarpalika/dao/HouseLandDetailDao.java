package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.HouseLandDetailModel;

public interface HouseLandDetailDao {

	public int save(HouseLandDetailModel h);

	public HouseLandDetailModel findById(String id);
	
	public int findMax();

	public void delete(String id);

	public void update(HouseLandDetailModel h, String id);

	public List<HouseLandDetailModel> findAll();
	

}
