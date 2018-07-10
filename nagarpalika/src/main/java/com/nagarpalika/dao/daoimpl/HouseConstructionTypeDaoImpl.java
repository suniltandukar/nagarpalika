package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseConstructionTypeDao;
import com.nagarpalika.model.HouseConstructionTypeModel;

@Repository
public class HouseConstructionTypeDaoImpl implements HouseConstructionTypeDao {
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<HouseConstructionTypeModel> findAll() {
		String query = "select * from house_construction_type";
		return template.query(query, new BeanPropertySqlParameterSource(new HouseConstructionTypeModel()),new BeanPropertyRowMapper<HouseConstructionTypeModel>(HouseConstructionTypeModel.class));
	}

}
