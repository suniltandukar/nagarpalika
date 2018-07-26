package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.DrinkingWaterTypeDao;
import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.service.DrinkingWaterTypeService;

@Service
public class DrinkingWaterTypeServiceImpl implements DrinkingWaterTypeService {

	@Autowired
	DrinkingWaterTypeDao drinkingWaterTypeDao;
	@Override
	public void save(DrinkingWaterTypeModel d) {
		drinkingWaterTypeDao.save(d);

	}

	@Override
	public List<DrinkingWaterTypeModel> findAll() {
		return drinkingWaterTypeDao.findAll();
	}

	@Override
	public DrinkingWaterTypeModel findById(String id) {
		return drinkingWaterTypeDao.findById(id);
	}

	@Override
	public void update(DrinkingWaterTypeModel d, String id) {
		drinkingWaterTypeDao.update(d, id);

	}

	@Override
	public void delete(String id) {
		drinkingWaterTypeDao.delete(id);

	}

	@Override
	public int findMax() {
		return drinkingWaterTypeDao.findMax();
	}

}
