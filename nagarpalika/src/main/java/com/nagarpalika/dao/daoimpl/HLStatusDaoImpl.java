package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HLStatusDao;
import com.nagarpalika.model.ConstructionTypeModel;
import com.nagarpalika.model.HLStatusModel;

@Repository
public class HLStatusDaoImpl implements HLStatusDao {
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(HLStatusModel h) {
		String query = "insert into hlstatustbl (hlstatus_id, hlstatus_name) values (:hlstatus_id,:hlstatus_name)";
		int status = template.update(query, new BeanPropertySqlParameterSource(h));
		return status;
	}

	@Override
	public int update(HLStatusModel h, String id) {
		String query = "update hlstatustbl set hlstatus_name = :hlstatus_name where hlstatus_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(h));
		return status;
	}

	@Override
	public List<HLStatusModel> findAll() {
		String query = "select * from hlstatustbl";
		List<HLStatusModel> list = template.query(query, new BeanPropertyRowMapper<HLStatusModel>(HLStatusModel.class));
		return list;
	}

	@Override
	public HLStatusModel findById(String id) {
		String query = "select * from hlstatustbl where hlstatus_id = '"+id+"'";
		HLStatusModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<HLStatusModel>(HLStatusModel.class));
		return d;
	}

	@Override
	public int delete(String id) {
		String query = "delete from hlstatustbl where hlstatus_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(HLStatusModel.class));
		return status;
	}

}
