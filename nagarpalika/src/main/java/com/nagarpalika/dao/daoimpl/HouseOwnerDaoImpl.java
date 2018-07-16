package com.nagarpalika.dao.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseOwnerDao;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OwnerDetailModel;

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

		String sql="insert into house_owner_detail(house_owner_id, house_owner_fname, house_owner_mname,house_owner_lname,marital_status,grand_father_name,father_name,spouse_name,house_number,permanent_address,permanent_address_district,permanent_address_mun_vc,permanent_address_ward_no,temporary_address,gender,dob_nep,phone_number, mobile_no,email,education_status,occupation_id,disable_type,pan_number,record_status,company_id,branch_id,inputter,authorizer,date_time,curr_number)"
				+ "values(:house_owner_id,:house_owner_fname,:house_owner_mname,:house_owner_lname,:marital_status,:grand_father_name,:father_name,:spouse_name,:house_number,:permanent_address,:permanent_address_district,:permanent_address_mun_vc,:permanent_address_ward_no,:temporary_address,:gender,:dob_nep,:phone_number,:mobile_no,:email,:education_status,:occupation_id,:disable_type,:pan_number,:record_status,:company_id,:branch_id,:inputter,:authorizer,:date_time,:curr_number)";
		template.update(sql, new BeanPropertySqlParameterSource(hm));
		System.out.println(sql);
	}

	
	public HouseOwnerDetailModel editHouseOwner(String id) {

		String sql="select * from house_owner_detail where house_owner_id= '"+id+"'";
		return template.queryForObject(sql, new BeanPropertySqlParameterSource(id),new BeanPropertyRowMapper<HouseOwnerDetailModel>(HouseOwnerDetailModel.class));
	}
	@Override
	public void updateHouseOwner(String id, HouseOwnerDetailModel hm) {

		String sql="update house_owner_detail set house_owner_id=:house_owner_id, house_owner_fname=:house_owner_fname, house_owner_mname=:house_owner_mname,house_owner_lname=:house_owner_lname,marital_status=:marital_status,grand_father_name=:grand_father_name,father_name=:father_name,spouse_name=:spouse_name,house_number=:house_number,permanent_address=:permanent_address,permanent_address_district=:permanent_address_district,permanent_address_mun_vc=:permanent_address_mun_vc,permanent_address_ward_no=:permanent_address_ward_no,temporary_address=:temporary_address,gender=:gender,dob_nep=:dob_nep,phone_number=:phone_number, mobile_no=:mobile_no,email=:email,education_status=:education_status,occupation_id=:occupation_id,disable_type=:disable_type,pan_number=:pan_number,record_status=:record_status,company_id=:company_id,branch_id=:branch_id,inputter=:inputter,authorizer=:authorizer,date_time=:date_time,curr_number=:curr_number where house_owner_id='"+id+"'";
		template.update(sql, new BeanPropertySqlParameterSource(hm));
		System.out.println(sql);
	}
	@Override
	public void deleteHouseOwner(String id) {
		String sql="delete from house_owner_detail where house_owner_id='"+id+"'";
		template.update(sql, new BeanPropertySqlParameterSource(id));
	}
	@SuppressWarnings("unchecked")
	@Override
	public void insertOwnerIdentity(OwnerDetailModel owner,int i) {

		String sql="insert into owner_identity_detail(house_owner_id,id_type,id_number,issue_date,expiry_date,issued_by,record_status)"
				+ "values(:house_owner_id,:id_type,:id_number,:issue_date,:expiry_date,:issued_by,:record_status)";
		Map params=new HashMap();
		params.put("house_owner_id", owner.getHouse_owner_id().get(i));
		params.put("id_type",owner.getId_type().get(i));
		params.put("id_number", owner.getId_number().get(i));
		params.put("issue_date", owner.getIssue_date().get(i));
		params.put("expiry_date",owner.getExpiry_date().get(i));
		params.put("issued_by", owner.getIssued_by().get(i));
		params.put("record_status", owner.getRecord_status().get(i));
		
		template.update(sql, params);
		
		
	}
	@Override
	public List<OwnerDetailModel> editOwnerDetail(String id) {
		
		String sql="select * from owner_identity_detail where house_owner_id=?";
		return template.query(sql, new BeanPropertySqlParameterSource(new Object[] {id}),new BeanPropertyRowMapper<OwnerDetailModel>(OwnerDetailModel.class));
	}

}
