package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.RoadSizeModel;

public interface RoadSizeService {
	
	public int save(RoadSizeModel d);
	public List<RoadSizeModel> findAll();
	public RoadSizeModel findById(String id);
	public int update(RoadSizeModel r, String id);
	public int delete(String id);

}
