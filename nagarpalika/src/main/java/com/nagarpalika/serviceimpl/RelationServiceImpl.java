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

}
