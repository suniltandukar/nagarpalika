package com.nagarpalika.dao;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.nagarpalika.model.UserModel;


public interface UserDao {

	public boolean verifyUser(UserModel user);

	public UserModel getUserDetails(UserModel user);
	
	public boolean insertUser(UserModel u);
	
	public int updateUser(UserModel u);
	
	public List<UserModel> getUsers();
	
	public UserModel getSpecificUserDetails(String userid);

	//public String sessionUsername(HttpSession session);
}
