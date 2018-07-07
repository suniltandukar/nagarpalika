package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HouseOwnerDao;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.service.HouseOwnerService;

@Service
public class HouseOwnerServiceImpl implements HouseOwnerService {
	@Autowired
	HouseOwnerDao houseOwnerDao;

	@Override
	public List<HouseHoldDetailModel> findAll() {
		return houseOwnerDao.findAll();
	}

}