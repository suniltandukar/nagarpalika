package com.nagarpalika.service;

import java.util.ArrayList;
import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;
import com.nagarpalika.model.OwnerIdentityDetailModel;

public interface HouseOwnerService {
	public List<HouseHoldDetailModel> findAll();

	public int insertHouseOwner(HouseOwnerDetailModel hm);

	public HouseOwnerDetailModel editHouseOwner(String id);

	public void updateHouseOwner(String id, HouseOwnerDetailModel hm);

	public void deleteHouseOwner(String id);

	public void insertOwnerIdentity(HouseOwnerDetailModel owner,int i);

	public List<OwnerDetailModel> findById(String id);
	
	public int findMaxValue();
	
	public ArrayList<HouseHoldDetailModel> showAll();
}
