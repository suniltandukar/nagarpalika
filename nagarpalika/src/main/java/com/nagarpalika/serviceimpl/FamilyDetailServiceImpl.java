package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.service.FamilyDetailService;

@Service
public class FamilyDetailServiceImpl implements FamilyDetailService {

	@Autowired
	FamilyDetailDao familyDetailDao;

	@Override
	public int save(FamilyDetailModel f) {
		return familyDetailDao.save(f);

	}

	@Override
	public List<FamilyDetailModel> getFamilyDetail() {

		return familyDetailDao.getFamilyDetail();
	}

	@Override
	public FamilyDetailModel findById(String id) {
		return familyDetailDao.findById(id);
	}

	@Override
	public void update(FamilyDetailModel f, String id) {
		familyDetailDao.update(f, id);
	}

	@Override
	public void delete(String id) {
		familyDetailDao.delete(id);
	}

	@Override
	public int findMax() {
		return familyDetailDao.findMax();
	}

	@Override
	public List<FamilyDetailModel> findByHouseOwnerId(String id) {
		return familyDetailDao.findByHouseOwnerId(id);
	}

	@Override
	public List<FamilyDetailModel> findAll() {
		return familyDetailDao.findAll();
	}

}
