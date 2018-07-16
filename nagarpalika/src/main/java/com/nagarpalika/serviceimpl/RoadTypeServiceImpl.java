package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.RoadTypeDao;
import com.nagarpalika.model.RoadTypeModel;
import com.nagarpalika.service.RoadTypeService;

@Service
public class RoadTypeServiceImpl implements RoadTypeService {
	
	@Autowired
	RoadTypeDao roadTypeDao;

	@Override
	public void save(RoadTypeModel d) {
		roadTypeDao.save(d);
	}

	@Override
	public List<RoadTypeModel> findAll() {
		return roadTypeDao.findAll();
	}

	@Override
	public RoadTypeModel findById(String id) {
		return roadTypeDao.findById(id);
	}

	@Override
	public int findMax() {
		return roadTypeDao.findMax();
	}

	@Override
	public void update(RoadTypeModel r, String id) {
		roadTypeDao.update(r, id);

	}

	@Override
	public void delete(String id) {
		roadTypeDao.delete(id);

	}

}
