package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseConstructionTypeModel;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.RelationModel;

public interface RestService {
	
	public List<OccupationModel> getOccupation();
	public List<EducationDetailModel> getEducation();
	public List<DisableTypeModel> getDisableType();
	public List<RelationModel> getRelation();
	public List<HouseHoldDetailModel> getHouseHoldDetail();
	public List<FamilyDetailModel> getFamilyDetail();
	public List<HouseConstructionTypeModel> getHouseConstruction();

}
