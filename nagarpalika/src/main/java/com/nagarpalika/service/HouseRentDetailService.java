package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.HouseRentDetailModel;

public interface HouseRentDetailService {
	
	public int save(HouseRentDetailModel h);

	public HouseRentDetailModel findById(String id);
	
	public int findMax();

	public void delete(String id);

	public void update(HouseRentDetailModel h, String id);

	public List<HouseRentDetailModel> findAll();


}
