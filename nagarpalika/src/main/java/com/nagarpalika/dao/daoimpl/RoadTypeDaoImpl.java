package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.RoadTypeDao;
import com.nagarpalika.model.RoadTypeModel;

@Repository
public class RoadTypeDaoImpl implements RoadTypeDao {
private NamedParameterJdbcTemplate template;
@Autowired
public void SetDataSource(DataSource dataSource){
	this.template = new NamedParameterJdbcTemplate(dataSource);
}
	@Override
	public void save(RoadTypeModel d) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoadTypeModel> findAll() {
		String query = "select * from road_type";
		return template.query(query, new BeanPropertyRowMapper<RoadTypeModel>(RoadTypeModel.class));
	}

	@Override
	public RoadTypeModel findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(RoadTypeModel r, String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
