package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.RoadTypeModel;

public interface RoadTypeDao {
	public void save(RoadTypeModel d);
	public List<RoadTypeModel> findAll();
	public RoadTypeModel findById(String id);
	public int findMax();
	public void update(RoadTypeModel r, String id);
	public void delete(String id);

}
