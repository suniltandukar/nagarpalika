package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.BusinessTypeModel;
import com.nagarpalika.model.RoadSizeModel;

public interface BusinessTypeDao {
	
	public int save(BusinessTypeModel d);
	public List<BusinessTypeModel> findAll();
	public BusinessTypeModel findById(String id);
	public int update(BusinessTypeModel r, String id);
	public int delete(String id);

}
