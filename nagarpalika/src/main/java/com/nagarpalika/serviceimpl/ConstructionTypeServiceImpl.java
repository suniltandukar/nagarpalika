package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.ConstructionTypeDao;
import com.nagarpalika.model.ConstructionTypeModel;
import com.nagarpalika.service.ConstructionTypeService;

@Service
public class ConstructionTypeServiceImpl implements ConstructionTypeService {
	
	@Autowired
	ConstructionTypeDao constructionTypeDao;

	@Override
	public int save(ConstructionTypeModel c) {
		return constructionTypeDao.save(c);
	}

	@Override
	public int update(ConstructionTypeModel c, String id) {
		return constructionTypeDao.update(c, id);
	}

	@Override
	public List<ConstructionTypeModel> findAll() {
		return constructionTypeDao.findAll();
	}

	@Override
	public ConstructionTypeModel findById(String id) {
		return constructionTypeDao.findById(id);
	}

	@Override
	public int delete(String id) {
		return constructionTypeDao.delete(id);
	}

}
