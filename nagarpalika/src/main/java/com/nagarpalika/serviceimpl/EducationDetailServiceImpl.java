package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.service.EducationDetailService;

@Component("educationDetailServiceBean")
public class EducationDetailServiceImpl implements EducationDetailService {
	@Autowired
	EducationDetailDao educationDetailDao;

	public void save(EducationDetailModel e) {
		educationDetailDao.save(e);
	}

	public List<EducationDetailModel> getEducationDetail() {
		return educationDetailDao.getEducationDetail();
	}

	@Override
	public EducationDetailModel getEducationSpecificDetail(String id) {
		return educationDetailDao.getEducationSpecificDetail(id);
	}

	public void update(EducationDetailModel e, String id) {
		educationDetailDao.update(e, id);
	}

	public void delete(String id) {
		educationDetailDao.delete(id);
	}

}
