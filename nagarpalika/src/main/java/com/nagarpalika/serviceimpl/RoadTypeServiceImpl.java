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
	public int save(RoadTypeModel d) {
		return roadTypeDao.save(d);
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
	public int update(RoadTypeModel r, String id) {
		return roadTypeDao.update(r, id);

	}

	@Override
	public int delete(String id) {
		return roadTypeDao.delete(id);

	}

}
