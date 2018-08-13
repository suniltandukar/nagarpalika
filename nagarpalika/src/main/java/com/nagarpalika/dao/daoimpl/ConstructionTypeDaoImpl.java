package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;   

import com.nagarpalika.dao.ConstructionTypeDao;
import com.nagarpalika.model.ConstructionTypeModel;
import com.nagarpalika.model.DisableTypeModel;

@Repository
public class ConstructionTypeDaoImpl implements ConstructionTypeDao {
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(ConstructionTypeModel c) {
		String query = "insert into constructiontypetbl (construction_name) values (:construction_name)";
		int status = template.update(query, new BeanPropertySqlParameterSource(c));
		return status;
	}

	@Override
	public int update(ConstructionTypeModel c, String id) {
		String query = "update constructiontypetbl set construction_name = :construction_name where construction_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(c));
		return status;
	}

	@Override
	public List<ConstructionTypeModel> findAll() {
		String query = "select * from constructiontypetbl";
		List<ConstructionTypeModel> list = template.query(query, new BeanPropertyRowMapper<ConstructionTypeModel>(ConstructionTypeModel.class));
		return list;
	}

	@Override
	public ConstructionTypeModel findById(String id) {
		String query = "select * from constructiontypetbl where construction_id = '"+id+"'";
		ConstructionTypeModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<ConstructionTypeModel>(ConstructionTypeModel.class));
		return d;
	}

	@Override
	public int delete(String id) {
		String query = "delete from constructiontypetbl where construction_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(ConstructionTypeModel.class));
		return status;
	}

}
