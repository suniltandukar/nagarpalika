package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

public interface HouseOwnerDao {
	public List<HouseHoldDetailModel> findAll();
	
	public void insertHouseOwner(HouseOwnerDetailModel hm);
	

}
