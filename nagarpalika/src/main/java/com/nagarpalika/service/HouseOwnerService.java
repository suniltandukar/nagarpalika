package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

public interface HouseOwnerService {
	public List<HouseHoldDetailModel> findAll();

	public void insertHouseOwner(HouseOwnerDetailModel hm);
}
