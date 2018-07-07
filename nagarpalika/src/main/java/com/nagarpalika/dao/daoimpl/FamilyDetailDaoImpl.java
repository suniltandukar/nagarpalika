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

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;

@Repository
public class FamilyDetailDaoImpl implements FamilyDetailDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
		
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
			this.jdbcTemplate=jdbcTemplate;
		}
		
		@Autowired
		public void setDataSource(DataSource dataSource){
			this.jdbcTemplate=new JdbcTemplate(dataSource);
			this.template = new NamedParameterJdbcTemplate(dataSource);
		}
	
	public void save(FamilyDetailModel f){
		String query="insert into family_detail (house_owner_id, house_owner_fname, house_owner_mname, house_owner_lname, relation, marital_status, dob_nep ,disable_type, occupation_id, gender, date_time) values ( :house_owner_id, :house_owner_fname, :house_owner_mname, :house_owner_lname, :relation, :marital_status, :dob_nep , :disable_type, :occupation_id, :gender, now())";
		template.update(query, new BeanPropertySqlParameterSource(f));
	}

	public List<FamilyDetailModel> getFamilyDetail() {
		String query = "select * from family_detail";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<FamilyDetailModel>(FamilyDetailModel.class));
	}
	
	public FamilyDetailModel findById(String id){
		String query="select * from family_detail where family_detail_id = ?";
		FamilyDetailModel familyDetailModel = jdbcTemplate.queryForObject(query, new Object[] {id},new BeanPropertyRowMapper(FamilyDetailModel.class));
	return familyDetailModel;
	}
	
	public int findMax(){
		String query="select max(family_detail_id) from family_detail";
		return template.queryForInt(query, new BeanPropertySqlParameterSource(FamilyDetailModel.class));
	}
	
	public void update(FamilyDetailModel f, String id){
		String query="update family_detail set house_owner_id= :house_owner_id, house_owner_fname= :house_owner_fname, house_owner_mname= :house_owner_mname, house_owner_lname = :house_owner_lname, relation= :relation, marital_status= :marital_status, dob_nep= :dob_nep, disable_type = :disable_type, occupation_id= :occupation_id, gender= :gender where family_detail_id='"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(f));
	}
	
	public void delete(String id){
		String query="delete from family_detail where family_detail_id = ?";
		jdbcTemplate.update(query, new Object[] {id});
	}
	
	
}
