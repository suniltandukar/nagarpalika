package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.TenantsDetailDao;
import com.nagarpalika.model.TenantDetailModel;
import com.nagarpalika.service.TenantsDetailService;

@Service
public class TenantsDetailServiceImpl implements TenantsDetailService {
	@Autowired
	TenantsDetailDao tenantsDetailDao;

	@Override
	public int save(TenantDetailModel t) {
		return tenantsDetailDao.save(t);
	}

	@Override
	public TenantDetailModel findById(String id) {
		return tenantsDetailDao.findById(id);
	}

	@Override
	public int findMax() {
		return tenantsDetailDao.findMax();
	}

	@Override
	public void delete(String id) {
		tenantsDetailDao.delete(id);
	}

	@Override
	public void update(TenantDetailModel t, String id) {
		tenantsDetailDao.update(t, id);
	}

	@Override
	public List<TenantDetailModel> findAll() {
		return tenantsDetailDao.findAll();
	}

}
