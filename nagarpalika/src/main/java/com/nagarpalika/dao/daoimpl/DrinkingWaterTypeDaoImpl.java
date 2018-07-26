package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.DrinkingWaterTypeDao;
import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseFacilityDetailModel;

@Repository	
public class DrinkingWaterTypeDaoImpl implements DrinkingWaterTypeDao {

	private NamedParameterJdbcTemplate template;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void save(DrinkingWaterTypeModel d) {
		String query = "insert into drinking_water_type (drinking_water_type)values (:drinking_water_type)";
		template.update(query, new BeanPropertySqlParameterSource(d));

	}

	@Override
	public List<DrinkingWaterTypeModel> findAll() {
		String query = "select * from drinking_water_type";
		return template.query(query, new BeanPropertyRowMapper<DrinkingWaterTypeModel>(DrinkingWaterTypeModel.class));
	}

	@Override
	public DrinkingWaterTypeModel findById(String id) {
		String query = "select * from drinking_water_type where drinking_water_type_id = '"+id+"'";
		return template.queryForObject(query, new BeanPropertySqlParameterSource(DrinkingWaterTypeModel.class), new BeanPropertyRowMapper<DrinkingWaterTypeModel>(DrinkingWaterTypeModel.class));
	}

	@Override
	public void update(DrinkingWaterTypeModel d, String id) {
		String query = "update drinking_water_type set drinking_water_type = :drinking_water_type where drinking_water_type_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(d));
		
	}

	@Override
	public void delete(String id) {
		String query = "delete from drinking_water_type where drinking_water_type_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(DrinkingWaterTypeModel.class));
		
	}

	@Override
	public int findMax() {
		String query = "select max(drinking_water_type_id) as drinking_water_type_id from drinking_water_type";
		int max_value = template.queryForObject(query, new BeanPropertySqlParameterSource(FamilyDetailModel.class), Integer.class);
		return max_value;
	}

}
