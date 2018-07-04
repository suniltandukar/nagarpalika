package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.FormDetailDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.service.FormDetailService;

@Service
public class FromDetailServiceImpl implements FormDetailService {

	@Autowired
	FormDetailDao formDetailDao;
	
	public List<DisableTypeModel> getDisableType() {
		return formDetailDao.getDisableType();
	}

}
