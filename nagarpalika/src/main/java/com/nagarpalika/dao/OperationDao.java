package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.UserModel;



public interface OperationDao {
	public List<UserModel> getSystemDetails();

	public boolean updateGeneralSetting(UserModel user);

	public boolean insertTableDetail(String tablename,String columns, String value);
	 

	

}
