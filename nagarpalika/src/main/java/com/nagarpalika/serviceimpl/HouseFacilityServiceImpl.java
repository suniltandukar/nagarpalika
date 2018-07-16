package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HouseFacilityDao;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.service.HouseFacilityService;

@Service
public class HouseFacilityServiceImpl implements HouseFacilityService {
	@Autowired
	HouseFacilityDao houseFacilityDao;

	@Override
	public int save(HouseFacilityDetailModel h) {
		return houseFacilityDao.save(h);
	}

	@Override
	public HouseFacilityDetailModel findById(String id) {
		return houseFacilityDao.findById(id);
	}

	@Override
	public int findMax() {
		return houseFacilityDao.findMax();
	}

	@Override
	public void delete(String id) {
		houseFacilityDao.delete(id);
	}

	@Override
	public void update(HouseFacilityDetailModel h, String id) {
		houseFacilityDao.update(h, id);
	}

	@Override
	public List<HouseFacilityDetailModel> findAll() {
		return houseFacilityDao.findAll();
	}

}
