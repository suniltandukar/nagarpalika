package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.RoadSizeDao;
import com.nagarpalika.model.RoadSizeModel;
import com.nagarpalika.service.RoadSizeService;

@Service
public class RoadSizeServiceImpl implements RoadSizeService {
	@Autowired
	RoadSizeDao roadSizeDao;

	@Override
	public int save(RoadSizeModel d) {
		return roadSizeDao.save(d);
	}

	@Override
	public List<RoadSizeModel> findAll() {
		return roadSizeDao.findAll();
	}

	@Override
	public RoadSizeModel findById(String id) {
		return roadSizeDao.findById(id);
	}

	@Override
	public int update(RoadSizeModel r, String id) {
		return roadSizeDao.update(r, id);
	}

	@Override
	public int delete(String id) {
		return roadSizeDao.delete(id);
	}

}
