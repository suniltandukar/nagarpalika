package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.HouseLandDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;

@Repository
public class HouseLandDetailDaoImpl implements HouseLandDetailDao {

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int save(HouseLandDetailModel h) {
		String query = "insert into house_and_land_detail (house_owner_id,land_house_id,inputter,family_id,ownership_type,house_number,land_unit,land_size,plot_num,sheet_num,district_uni,mun_vc_uni,ward_no_uni,moth_num_uni,kitta_num_uni,land_legacy_address,land_current_district,land_current_mun_vc,ward_no,tole,house_construction_type, used_status, house_floor_count, rented_floor_count, house_area_unit, house_area, map_application_date, map_approved_date, construction_start_date,property_type_for_tax, curr_number) values ("
				+ ":houseOwnerDetailModel.house_owner_id,:land_house_id,:inputter, :family_id,:ownership_type, :house_number,:land_unit,:land_size,:plot_num,:sheet_num,:district_uni,:mun_vc_uni,:ward_no_uni,:moth_num_uni,:kitta_num_uni,:land_legacy_address,:land_current_district,:land_current_mun_vc,:ward_no,:tole,:house_construction_type, :used_status, :house_floor_count, :rented_floor_count, :house_area_unit, :house_area, :map_application_date, :map_approved_date, :construction_start_date,:property_type_for_tax,1)";
		int i = template.update(query, new BeanPropertySqlParameterSource(h));
		if (i > 0) {
			return i;
		}
		return 0;
	}

	public HouseLandDetailModel findById(String id) {
		String query = "select * from house_and_land_detail where house_and_land_detail_id='" + id + "'";
		return template.queryForObject(query,new BeanPropertySqlParameterSource(new HouseLandDetailModel()),new HouseLandRowMapper());
	}

	@Override
	public int findMax() {
		String query = "select max(house_and_land_detail_id) as house_and_land_detail_id from house_and_land_detail";
		int max_value = template.queryForInt(query, new BeanPropertySqlParameterSource(HouseLandDetailModel.class));
		try {
			return max_value;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public void delete(String id) {
		String query = "delete from house_and_land_detail where house_and_land_detail_id = ?";
		jdbcTemplate.update(query, new Object[] { id });
	}

	@Override
	public void update(HouseLandDetailModel h, String id) {
		String query = "update house_and_land_detail set house_owner_id= :houseOwnerDetailModel.house_owner_id,land_house_id=:land_house_id,family_id=:family_id,ownership_type=:ownership_type,house_number=:house_number,land_unit=:land_unit,land_size=:land_size,plot_num=:plot_num,sheet_num=:sheet_num,district_uni=:district_uni,mun_vc_uni=:mun_vc_uni,ward_no_uni=:ward_no_uni,moth_num_uni=:moth_num_uni,kitta_num_uni=:kitta_num_uni,land_legacy_address=:land_legacy_address,land_current_district=:land_current_district,land_current_mun_vc=:land_current_mun_vc,ward_no=:ward_no,tole=:tole,house_construction_type=:house_construction_type, used_status=:used_status, house_floor_count=:house_floor_count, rented_floor_count=:rented_floor_count, house_area_unit=:house_area_unit, house_area=:house_area, map_application_date=:map_application_date, map_approved_date=:map_approved_date, construction_start_date=:construction_start_date, property_type_for_tax=:property_type_for_tax where house_and_land_detail_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(h));
	}

	@Override
	public List<HouseLandDetailModel> findAll() {
		String query = "select * from house_and_land_detail";
		

		List<HouseLandDetailModel> houseLandDetail = template.query(query, new BeanPropertySqlParameterSource(new HouseLandDetailModel()),new HouseLandRowMapper());
		try{
			return houseLandDetail;
		}
		catch(EmptyResultDataAccessException e){
			System.out.println(e);
			return null;
		}
	}
	public class HouseLandRowMapper implements RowMapper<HouseLandDetailModel> {
		 @Override
		    public HouseLandDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			 HouseOwnerDetailModel houseOwnerDetailModel = (new BeanPropertyRowMapper<HouseOwnerDetailModel>(HouseOwnerDetailModel.class)).mapRow(rs,rowNum);
			 HouseLandDetailModel houseLandDetailModel = (new BeanPropertyRowMapper<HouseLandDetailModel>(HouseLandDetailModel.class)).mapRow(rs,rowNum);
			 houseLandDetailModel.setHouseOwnerDetailModel(houseOwnerDetailModel);
		        return houseLandDetailModel;
		     }
	}
	
	
}
