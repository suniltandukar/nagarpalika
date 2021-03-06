package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.DrinkingWaterTypeModel;

public interface DrinkingWaterTypeService {
	public void save(DrinkingWaterTypeModel d);
	public List<DrinkingWaterTypeModel> findAll();
	public DrinkingWaterTypeModel findById(String id);
	public int findMax();
	public void update(DrinkingWaterTypeModel d, String id);
	public void delete(String id);
	
}
