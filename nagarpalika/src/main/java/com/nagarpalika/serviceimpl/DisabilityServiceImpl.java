package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.DisabilityDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.service.DisabilityService;

@Service
public class DisabilityServiceImpl implements DisabilityService {
	@Autowired
	DisabilityDao disabilityDao;

	@Override
	public int save(DisableTypeModel d) {
		return disabilityDao.save(d);

	}

	@Override
	public int update(DisableTypeModel d, String id) {
		return disabilityDao.update(d, id);

	}

	@Override
	public List<DisableTypeModel> findAll() {
		return disabilityDao.findAll();
	}

	@Override
	public DisableTypeModel findById(String id) {
		return disabilityDao.findById(id);
	}

	@Override
	public int delete(String id) {
		return disabilityDao.delete(id);
	}

}
