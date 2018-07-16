package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;

public interface HouseOwnerDao {
	public List<HouseHoldDetailModel> findAll();
	
	public void insertHouseOwner(HouseOwnerDetailModel hm);

	public HouseOwnerDetailModel editHouseOwner(String id);
	

	public void updateHouseOwner(String id, HouseOwnerDetailModel hm);

	public void deleteHouseOwner(String id);

	public void insertOwnerIdentity(OwnerDetailModel owner,int i);

	public List<OwnerDetailModel> editOwnerDetail(String id);
}
