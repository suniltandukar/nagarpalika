package com.nagarpalika.service;

import java.util.List;

import com.nagarpalika.model.EducationDetailModel;

public interface EducationDetailService {
	public void save(EducationDetailModel e);

	public List<EducationDetailModel> getEducationDetail();

	public EducationDetailModel getEducationSpecificDetail(String id);

	public void update(EducationDetailModel e, String id);

	public void delete(String id);

}
