package com.nagarpalika.dao.daoimpl;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseHoldDao;
import com.nagarpalika.model.HouseHoldDetailModel;

@Repository
public class HouseHoldDaoImpl implements HouseHoldDao {

	NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean insertHouseHold(HouseHoldDetailModel hm){
		String query ="insert into";
		
		
		
		
		return false;
	}
}
