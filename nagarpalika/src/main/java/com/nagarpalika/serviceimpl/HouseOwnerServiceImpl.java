package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.HouseOwnerDao;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;
import com.nagarpalika.service.HouseOwnerService;

@Service
public class HouseOwnerServiceImpl implements HouseOwnerService {
	@Autowired
	HouseOwnerDao houseOwnerDao;

	@Override
	public List<HouseHoldDetailModel> findAll() {
		return houseOwnerDao.findAll();
	}
	
	@Override
	public void insertHouseOwner(HouseOwnerDetailModel hm) {
		houseOwnerDao.insertHouseOwner(hm);
	}
	
	public HouseOwnerDetailModel editHouseOwner(String id){
		return houseOwnerDao.editHouseOwner(id);
		
	}
	
	public void updateHouseOwner(String id, HouseOwnerDetailModel hm)
	{
		 houseOwnerDao.updateHouseOwner(id, hm);
	}

	public void deleteHouseOwner(String id) {

		houseOwnerDao.deleteHouseOwner(id);
	}

	@Override
	public void insertOwnerIdentity(OwnerDetailModel owner,int i) {
		houseOwnerDao.insertOwnerIdentity(owner,i);
	}

	@Override
	public List<OwnerDetailModel> editOwnerDetail(String id) {
		return houseOwnerDao.editOwnerDetail(id);
	}

}
