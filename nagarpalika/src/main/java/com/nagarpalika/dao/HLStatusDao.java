package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.HLStatusModel;

public interface HLStatusDao {
	
	public int save(HLStatusModel h);
	public int update(HLStatusModel h, String id);
	public List<HLStatusModel> findAll();
	public HLStatusModel findById(String id);
	public int delete(String id);

}
