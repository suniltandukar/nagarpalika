package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.EducationDetailModel;

public interface EducationDetailDao {
	public void save(EducationDetailModel e);

	public List<EducationDetailModel> getEducationDetail();

	public EducationDetailModel getEducationSpecificDetail(String id);

	public void update(EducationDetailModel e, String id);

	public void delete(String id);

}
