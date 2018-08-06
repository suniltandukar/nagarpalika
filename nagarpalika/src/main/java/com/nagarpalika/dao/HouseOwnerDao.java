package com.nagarpalika.dao;

import java.util.ArrayList;
import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;

public interface HouseOwnerDao {
	public List<HouseHoldDetailModel> findAll();
	
	public ArrayList<HouseHoldDetailModel> showAll();
	
	public int insertHouseOwner(HouseOwnerDetailModel hm);

	public HouseOwnerDetailModel editHouseOwner(String id);
	

	public void updateHouseOwner(String id, HouseOwnerDetailModel hm);

	public void deleteHouseOwner(String id);

	public void insertOwnerIdentity(HouseOwnerDetailModel owner,int i);

	public List<OwnerDetailModel> findById(String id);
	
	public int findMaxValue();
	
	
}
