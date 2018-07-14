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

import com.nagarpalika.dao.HouseFacilityDao;
import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

@Repository
public class HouseFacilityDaoImpl implements HouseFacilityDao {
	private NamedParameterJdbcTemplate template;
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void SetDataSourceTag(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(HouseFacilityDetailModel h) {
		String query = "insert into house_facility_detail (house_owner_id, land_house_id, drinking_water_type_id, drinking_water_sufficiency, drainage_management, electricity_facility, street_light_facility, telephone_facility, internet_facility, tv_facility, road_type_id, road_width, date_time) values "
				+ "(:houseOwnerDetailModel.house_owner_id, :land_house_id, :drinkingWaterTypeModel.drinking_water_type_id, :drinking_water_sufficiency, :drainage_management, :electricity_facility, :street_light_facility, :telephone_facility, :internet_facility, :tv_facility, :road_type_id, :road_width, now())";
		int value = template.update(query, new BeanPropertySqlParameterSource(h));
		return value;
	}

	@Override
	public HouseFacilityDetailModel findById(String id) {
		String query = "select * from house_facility_detail where house_facility_id = '" + id + "'";
		return template.queryForObject(query, new BeanPropertySqlParameterSource(HouseFacilityDetailModel.class),
				new HouseFacilityRowMapper());
	}

	@Override
	public int findMax() {
		String query = "select max(house_facility_id) as house_facility_id from house_facility_detail";
		int max_value = template.queryForObject(query,
				new BeanPropertySqlParameterSource(HouseFacilityDetailModel.class), Integer.class);
		return max_value;
	}

	@Override
	public void delete(String id) {
		String query = "delete from house_facility_detail where house_facility_id = ?";
		jdbcTemplate.update(query, new Object[] { id });
		

	}

	@Override
	public void update(HouseFacilityDetailModel h, String id) {
		String query = "update house_facility_detail set house_owner_id= :houseOwnerDetailModel.house_owner_id, land_house_id=:land_house_id, drinking_water_type_id=:drinkingWaterTypeModel.drinking_water_type_id, drinking_water_sufficiency=:drinking_water_sufficiency, drainage_management=:drainage_management, electricity_facility=:electricity_facility, street_light_facility=:street_light_facility, telephone_facility=:telephone_facility, internet_facility=:internet_facility, tv_facility=:tv_facility, road_type_id=:road_type_id, road_width=:road_width, date_time=now() where house_facility_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(h));
	}

	@Override
	public List<HouseFacilityDetailModel> findAll() {
		String query = "select * from house_facility_detail";
		
		return template.query(query, new HouseFacilityRowMapper());
	}

	public class HouseFacilityRowMapper implements RowMapper<HouseFacilityDetailModel> {
		@Override
		public HouseFacilityDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseOwnerDetailModel houseOwnerDetailModel = (new BeanPropertyRowMapper<HouseOwnerDetailModel>(
					HouseOwnerDetailModel.class)).mapRow(rs, rowNum);
			DrinkingWaterTypeModel drinkingWaterTypeModel = (new BeanPropertyRowMapper<DrinkingWaterTypeModel>(
					DrinkingWaterTypeModel.class)).mapRow(rs, rowNum);
			HouseFacilityDetailModel houseFacilityDetailModel = (new BeanPropertyRowMapper<HouseFacilityDetailModel>(
					HouseFacilityDetailModel.class)).mapRow(rs, rowNum);
			
			houseFacilityDetailModel.setHouseOwnerDetailModel(houseOwnerDetailModel);
			houseFacilityDetailModel.setDrinkingWaterTypeModel(drinkingWaterTypeModel);
			return houseFacilityDetailModel;
		}

	}

}
