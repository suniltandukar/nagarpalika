package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.TenantDetailModel;

public interface TenantsDetailService {

	public int save(TenantDetailModel t);

	public TenantDetailModel findById(String id);
	
	public int findMax();

	public void delete(String id);

	public void update(TenantDetailModel t, String id);

	public List<TenantDetailModel> findAll();

}
