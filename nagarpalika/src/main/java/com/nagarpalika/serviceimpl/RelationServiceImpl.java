package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.RelationDao;
import com.nagarpalika.model.RelationModel;
import com.nagarpalika.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService {
	@Autowired
	RelationDao relationDao;

	@Override
	public List<RelationModel> findAll() {
		return relationDao.findAll();
	}

	@Override
	public int save(RelationModel d) {
		return relationDao.save(d);
	}

	@Override
	public int update(RelationModel d, String id) {
		return relationDao.update(d, id);
	}

	@Override
	public RelationModel findById(String id) {
		return relationDao.findById(id);
	}

	@Override
	public int delete(String id) {
		return relationDao.delete(id);
	}

}
