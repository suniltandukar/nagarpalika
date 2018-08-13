package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.ConstructionTypeModel;

public interface ConstructionTypeDao {
	
	public int save(ConstructionTypeModel c);
	public int update(ConstructionTypeModel c, String id);
	public List<ConstructionTypeModel> findAll();
	public ConstructionTypeModel findById(String id);
	public int delete(String id);

}
