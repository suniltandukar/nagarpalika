package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.RoadTypeModel;

public interface RoadTypeService {
	public void save(RoadTypeModel d);
	public List<RoadTypeModel> findAll();
	public RoadTypeModel findById(String id);
	public int findMax();
	public void update(RoadTypeModel r, String id);
	public void delete(String id);


}
