package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.DisabilityDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.DrinkingWaterTypeModel;

@Repository
public class DisabilityDaoImpl implements DisabilityDao {
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}


	@Override
	public int save(DisableTypeModel d) {
		String query = "insert into disabledtype (id, typehead) values (:id,:typehead)";
		int status = template.update(query, new BeanPropertySqlParameterSource(d));
		return status;

	}

	@Override
	public int update(DisableTypeModel d, String id) {
		String query = "update disabledtype set typehead = :typehead where id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(d));
		return status;
	}

	@Override
	public List<DisableTypeModel> findAll() {
		String query = "select * from disabledtype";
		List<DisableTypeModel> list = template.query(query, new BeanPropertyRowMapper<DisableTypeModel>(DisableTypeModel.class));
		return list;
	}

	@Override
	public DisableTypeModel findById(String id) {
		String query = "select * from disabledtype where id = '"+id+"'";
		DisableTypeModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<DisableTypeModel>(DisableTypeModel.class));
		return d;
	}


	@Override
	public int delete(String id) {
		String query = "delete from disabledtype where id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(DisableTypeModel.class));
		return status;
	}

}
