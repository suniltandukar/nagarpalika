package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.RelationModel;

public interface RelationDao {
	
	public int save(RelationModel d);
	public int update(RelationModel d, String id);
	public List<RelationModel> findAll();
	public RelationModel findById(String id);
	public int delete(String id);
	

}
