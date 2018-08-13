package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.RestDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseConstructionTypeModel;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.RelationModel;
import com.nagarpalika.service.RestService;

@Service
public class RestServiceImpl implements RestService {
	@Autowired
	RestDao restDao;

	@Override
	public List<OccupationModel> getOccupation() {
		return restDao.getOccupation();
	}

	@Override
	public List<EducationDetailModel> getEducation() {
		return restDao.getEducation();
	}

	@Override
	public List<DisableTypeModel> getDisableType() {
		return restDao.getDisableType();
	}

	@Override
	public List<RelationModel> getRelation() {
		return restDao.getRelation();
	}

	@Override
	public List<HouseHoldDetailModel> getHouseHoldDetail() {
		return restDao.getHouseHoldDetail();
	}

	@Override
	public List<FamilyDetailModel> getFamilyDetail() {
		return restDao.getFamilyDetail();
	}

	@Override
	public List<HouseConstructionTypeModel> getHouseConstruction() {
		return restDao.getHouseConstruction();
	}

}
