package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HouseRentDetailDao;
import com.nagarpalika.model.HouseRentDetailModel;
import com.nagarpalika.service.HouseRentDetailService;

@Service
public class HouseRentDetailServiceImpl implements HouseRentDetailService {
	
	@Autowired
	HouseRentDetailDao houseRentDetailDao;

	@Override
	public int save(HouseRentDetailModel h) {
		int value = houseRentDetailDao.save(h);
		return value;
	}

	@Override
	public HouseRentDetailModel findById(String id) {
		return houseRentDetailDao.findById(id);
	}

	@Override
	public int findMax() {
		int value = houseRentDetailDao.findMax();
		return value;
	}

	@Override
	public void delete(String id) {
		houseRentDetailDao.delete(id);
	}

	@Override
	public void update(HouseRentDetailModel h, String id) {
		houseRentDetailDao.update(h, id);
	}

	@Override
	public List<HouseRentDetailModel> findAll() {
		return houseRentDetailDao.findAll();
	}

}
