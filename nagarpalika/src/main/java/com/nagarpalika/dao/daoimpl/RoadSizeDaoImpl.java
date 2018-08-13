package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.RoadSizeDao;
import com.nagarpalika.model.RoadSizeModel;
import com.nagarpalika.model.RoadTypeModel;

@Repository
public class RoadSizeDaoImpl implements RoadSizeDao {
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void SetDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(RoadSizeModel d) {
		String query = "insert into road_size (road_size) values (:road_size)";
		int status = template.update(query, new BeanPropertySqlParameterSource(d));
		return status;
	}

	@Override
	public List<RoadSizeModel> findAll() {
		String query = "select * from road_size";
		return template.query(query, new BeanPropertyRowMapper<RoadSizeModel>(RoadSizeModel.class));
	}

	@Override
	public RoadSizeModel findById(String id) {
		String query = "select * from road_size where road_size_id = '"+id+"'";
		RoadSizeModel d = template.queryForObject(query, new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper<RoadSizeModel>(RoadSizeModel.class));
		return d;
	}

	@Override
	public int update(RoadSizeModel r, String id) {
		String query = "update road_size set road_size = :road_size where road_size_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(r));
		return status;
	}

	@Override
	public int delete(String id) {
		String query = "delete from road_size where road_size_id = '"+id+"'";
		int status = template.update(query, new BeanPropertySqlParameterSource(RoadSizeModel.class));
		return status;
	}

}
