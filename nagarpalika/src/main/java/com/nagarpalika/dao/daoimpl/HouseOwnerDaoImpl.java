package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseOwnerDao;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

@Repository
public class HouseOwnerDaoImpl implements HouseOwnerDao {
	private NamedParameterJdbcTemplate template;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public List<HouseHoldDetailModel> findAll() {
		String query="select * from house_owner_detail";
		return template.query(query, new BeanPropertySqlParameterSource(new HouseHoldDetailModel()), new BeanPropertyRowMapper<HouseHoldDetailModel>(HouseHoldDetailModel.class));

	}
	

	@Override
	public void insertHouseOwner(HouseOwnerDetailModel hm) {

		String sql="insert into house_owner_detail(house_owner_id, house_owner_fname, house_owner_mname,house_owner_lname,marital_status,grand_father_name,father_name,spouse_name,house_number,permanent_address,permanent_address_district,permanent_address_mun_vc,permanent_address_ward_no,	temporary_address,gender,dob_nep,phone_number, mobile_no,email,education_status,occupation_id,disable_type,pan_number,record_status,company_id,branch_id,inputter,authorizer,date_time,curr_number)"
				+ "values(:house_owner_id,:house_owner_fname,:house_owner_mname,:house_owner_lname,:marital_status,:grand_father_name,:father_name,:spouse_name,:house_number,:permanent_address,:permanent_address_district,:permanent_address_mun_vc,:permanent_address_ward_no,:temporary_address,:gender,:dob_nep,:phone_number,:mobile_no,:email,:education_status,:occupation_id,:disable_type,:pan_number,:record_status,:company_id,:branch_id,:inputter,:authorizer,:date_time,:curr_number)";
		template.update(sql, new BeanPropertySqlParameterSource(hm));
	}

	
	public HouseOwnerDetailModel editHouseOwner(String id) {

		String sql="select * from house_owner_detail where house_owner_id= ?";
		return template.queryForObject(sql, new BeanPropertySqlParameterSource(id),new BeanPropertyRowMapper<HouseOwnerDetailModel>(HouseOwnerDetailModel.class));
	}

}
