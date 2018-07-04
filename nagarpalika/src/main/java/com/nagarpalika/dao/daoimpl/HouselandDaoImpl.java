package com.nagarpalika.dao.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nagarpalika.dao.HouseLandDao;
import com.nagarpalika.model.HouseLandDetailModel;



public class HouselandDaoImpl implements HouseLandDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	public boolean insertHouseLand(HouseLandDetailModel h)
	{
		String query="insert into house_and_land_detail(house_owner_id,land_house_id,family_id,ownership_type,house_number,land_unit,land_size,plot_num,sheet_num,district_uni,mun_vc_uni,ward_no_uni,moth_num_uni,kitta_num_uni,land_legacy_address,land_current_district,land_current_mun_vc,ward_no,tole,house_construction_type,used_status,house_floor_count,rented_floor_count,house_area_unit,house_area,map_application_date,map_approved_date,construction_start_date,construction_completion_date,construction_completion_approval_date,completion_approved_by,house_map_prepared_by,inputter,authorizer,date_time,curr_number)"
				+ "values('"+h.getHouse_owener_id()+"','"+h.getLand_house_id()+"','"+h.getFamily_id()+"','"+h.getOwnership_type()+"','"+h.getHouse_number()+"','"+h.getLand_unit()+"','"+h.getLand_size()+"','"+h.getPlot_num()+"','"+h.getSheet_num()+"','"+h.getDistrict_uni()+"','"+h.getMun_vc_uni()+"','"+h.getWard_no_uni()+"','"+h.getMoth_num_uni()+"','"+h.getKitta_num_uni()+"','"+h.getLand_legacy_address()+"','"+h.getLand_current_district()+"','"+h.getLand_current_mun_vc()+"','"+h.getWard_no()+"','"+h.getTole()+"','"+h.getHouse_construction_type()+"','"+h.getUsed_status()+"','"+h.getHouse_area()+"','"+h.getHouse_floor_count()+"'";
		jdbcTemplate.update(query);
		return false;
	}
}
