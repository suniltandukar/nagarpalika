package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.OccupationDao;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.service.OccupationService;

@Service
public class OccupationServiceImpl implements OccupationService {
	
	@Autowired
	OccupationDao occupationDao;

	@Override
	public void save(OccupationModel o) {
		 occupationDao.save(o);
	}

	@Override
	public List<OccupationModel> findAll() {
		return occupationDao.findAll();
	}

	@Override
	public OccupationModel findById(String id) {
		return occupationDao.findById(id);
	}

	@Override
	public void update(OccupationModel o, String id) {
		occupationDao.update(o, id);

	}

	@Override
	public void delete(String id) {
		occupationDao.delete(id);

	}
	
	

}
