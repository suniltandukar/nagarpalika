package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.BusinessTypeDao;
import com.nagarpalika.model.BusinessTypeModel;

@Repository
public class BusinessTypeDaoImpl implements BusinessTypeDao {
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void SetDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(BusinessTypeModel d) {
		String query = "insert into business_type (business_type) values (:business_type)";
		int status = template.update(query, new BeanPropertySqlParameterSource(d));
		return status;
	}

	@Override
	public List<BusinessTypeModel> findAll() {
		String query = "select * from business_type";
		return template.query(query, new BeanPropertyRowMapper<BusinessTypeModel>(BusinessTypeModel.class));
	}

	@Override
	public BusinessTypeModel findById(String id) {
		String query = "select * from business_type where business_type_id = '"+id+"'";
		BusinessTypeModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<BusinessTypeModel>(BusinessTypeModel.class));
		return d;
	}

	@Override
	public int update(BusinessTypeModel r, String id) {
		String query = "update business_type set business_type = :business_type where business_type_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(r));
		return status;
	}

	@Override
	public int delete(String id) {
		String query = "delete from business_type where business_type_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(BusinessTypeModel.class));
		return status;
	}

}
