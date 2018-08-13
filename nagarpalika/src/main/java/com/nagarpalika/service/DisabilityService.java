package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.DisableTypeModel;

public interface DisabilityService {
	
	public int save(DisableTypeModel d);
	public int update(DisableTypeModel d, String id);
	public List<DisableTypeModel> findAll();
	public DisableTypeModel findById(String id);
	public int delete(String id);
	

}
