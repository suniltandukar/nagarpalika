package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.RoadTypeDao;
import com.nagarpalika.model.ConstructionTypeModel;
import com.nagarpalika.model.RoadTypeModel;

@Repository
public class RoadTypeDaoImpl implements RoadTypeDao {
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void SetDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(RoadTypeModel d) {
		String query = "insert into road_type (road_type) values (:road_type)";
		int status = template.update(query, new BeanPropertySqlParameterSource(d));
		return status;

	}

	@Override
	public List<RoadTypeModel> findAll() {
		String query = "select * from road_type";
		return template.query(query, new BeanPropertyRowMapper<RoadTypeModel>(RoadTypeModel.class));
	}

	@Override
	public RoadTypeModel findById(String id) {
		String query = "select * from road_type where road_type_id = '"+id+"'";
		RoadTypeModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<RoadTypeModel>(RoadTypeModel.class));
		return d;
	}


	@Override
	public int update(RoadTypeModel r, String id) {
		String query = "update road_type set road_type = :road_type where road_type_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(r));
		return status;
	

	}

	@Override
	public int delete(String id) {
		String query = "delete from road_type where road_type_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(RoadTypeModel.class));
		return status;

	}

}
