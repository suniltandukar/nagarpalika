package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HLStatusDao;
import com.nagarpalika.model.HLStatusModel;
import com.nagarpalika.service.HLStatusService;

@Service
public class HLStatusServiceImpl implements HLStatusService {
	@Autowired
	HLStatusDao hLStatusDao;

	@Override
	public int save(HLStatusModel h) {
		return hLStatusDao.save(h);
	}

	@Override
	public int update(HLStatusModel h, String id) {
		return hLStatusDao.update(h, id);
	}

	@Override
	public List<HLStatusModel> findAll() {
		return hLStatusDao.findAll();
	}

	@Override
	public HLStatusModel findById(String id) {
		return hLStatusDao.findById(id);
	}

	@Override
	public int delete(String id) {
		return hLStatusDao.delete(id);
	}

}
