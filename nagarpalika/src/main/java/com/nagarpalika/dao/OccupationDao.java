package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.OccupationModel;

public interface OccupationDao {
	
	public void save(OccupationModel o);

	public List<OccupationModel> findAll();

	public OccupationModel findById(String id);

	public void update(OccupationModel o, String id);

	public void delete(String id);

}
