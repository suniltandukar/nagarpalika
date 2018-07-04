package com.nagarpalika.dao;

import com.nagarpalika.model.HouseLandDetailModel;

public interface HouseLandDetailDao {

	public void save(HouseLandDetailModel h);

	public HouseLandDetailModel getSpecificHouseLand(String id);

}
