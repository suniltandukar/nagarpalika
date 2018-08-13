package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.RoadTypeModel;

public interface RoadTypeService {
	public int save(RoadTypeModel d);
	public List<RoadTypeModel> findAll();
	public RoadTypeModel findById(String id);
	public int update(RoadTypeModel r, String id);
	public int delete(String id);


}
