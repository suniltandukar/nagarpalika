package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HouseConstructionTypeDao;
import com.nagarpalika.model.HouseConstructionTypeModel;
import com.nagarpalika.service.HouseConstructionTypeService;

@Service
public class HouseConstructionTypeServiceImpl implements HouseConstructionTypeService {
	@Autowired
	HouseConstructionTypeDao houseConstructionTypeDao;

	@Override
	public List<HouseConstructionTypeModel> findAll() {
		return houseConstructionTypeDao.findAll();
	}

}
