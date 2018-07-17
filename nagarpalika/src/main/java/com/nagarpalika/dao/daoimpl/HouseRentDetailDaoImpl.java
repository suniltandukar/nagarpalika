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

import com.nagarpalika.dao.HouseRentDetailDao;
import com.nagarpalika.dao.daoimpl.HouseFacilityDaoImpl.HouseFacilityRowMapper;
import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.HouseRentDetailModel;

@Repository
public class HouseRentDetailDaoImpl implements HouseRentDetailDao {
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
	public int save(HouseRentDetailModel h) {
		String query = "insert into house_rent_detail (house_owner_id, land_house_id, rented_storied, rented_room, rented_from, rented_purpose, date_time, inputter, curr_number) values "
				+ "(:houseOwnerDetailModel.house_owner_id,:land_house_id,:rented_storied,:rented_room,:rented_from,:rented_purpose, now(), :inputter, 1)";
		int value = template.update(query, new BeanPropertySqlParameterSource(h));
		return value;	
		}

	@Override
	public HouseRentDetailModel findById(String id) {
		String query = "select * from house_rent_detail where house_rent_id = '" + id + "'";
		return template.queryForObject(query, new BeanPropertySqlParameterSource(HouseRentDetailModel.class), new HouseRentRowMapper());
	}

	@Override
	public int findMax() {
		String query = "select max(house_rent_id) as house_rent_id from house_rent_detail";
		int max_value = template.queryForObject(query,
				new BeanPropertySqlParameterSource(HouseRentDetailModel.class), Integer.class);
		return max_value;
	}

	@Override
	public void delete(String id) {
		String query = "delete from house_rent_detail where house_rent_id = ?";
		jdbcTemplate.update(query, new Object[] { id });
	}

	@Override
	public void update(HouseRentDetailModel h, String id) {
		String query = "update house_rent_detail set house_owner_id=:houseOwnerDetailModel.house_owner_id, land_house_id=:land_house_id, rented_storied=:rented_storied, rented_room=:rented_room, rented_from=:rented_from, rented_purpose=:rented_purpose, date_time=now(), inputter=:inputter where house_rent_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(h));

	}

	@Override
	public List<HouseRentDetailModel> findAll() {
		String query = "select * from house_rent_detail";
		return template.query(query, new HouseRentRowMapper());
	}

	public class HouseRentRowMapper implements RowMapper<HouseRentDetailModel> {
		@Override
		public HouseRentDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseOwnerDetailModel houseOwnerDetailModel = (new BeanPropertyRowMapper<HouseOwnerDetailModel>(
					HouseOwnerDetailModel.class)).mapRow(rs, rowNum);
			HouseRentDetailModel houseRentDetailModel = (new BeanPropertyRowMapper<HouseRentDetailModel>(
					HouseRentDetailModel.class)).mapRow(rs, rowNum);
			
			houseRentDetailModel.setHouseOwnerDetailModel(houseOwnerDetailModel);
			return houseRentDetailModel;
		}

	}
}
