package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.BusinessTypeDao;
import com.nagarpalika.model.BusinessTypeModel;
import com.nagarpalika.model.RoadSizeModel;
import com.nagarpalika.service.BusinessTypeService;

@Service
public class BusinessTypeServiceImpl implements BusinessTypeService {
	
	@Autowired
	BusinessTypeDao businessTypeDao;

	@Override
	public int save(BusinessTypeModel d) {
		return businessTypeDao.save(d);
	}

	@Override
	public List<BusinessTypeModel> findAll() {
		return businessTypeDao.findAll();
	}

	@Override
	public BusinessTypeModel findById(String id) {
		return businessTypeDao.findById(id);
	}

	@Override
	public int update(BusinessTypeModel r, String id) {
		return businessTypeDao.update(r, id);
	}

	@Override
	public int delete(String id) {
		return businessTypeDao.delete(id);
	}

}
