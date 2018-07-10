package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

public interface HouseOwnerService {
	public List<HouseHoldDetailModel> findAll();

	public void insertHouseOwner(HouseOwnerDetailModel hm);

	public HouseOwnerDetailModel editHouseOwner(String id);

	public void updateHouseOwner(String id, HouseOwnerDetailModel hm);

	public void deleteHouseOwner(String id);
}
