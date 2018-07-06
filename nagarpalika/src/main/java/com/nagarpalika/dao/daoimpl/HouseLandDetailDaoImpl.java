package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.HouseLandDetailModel;

public class HouseLandDetailDaoImpl implements HouseLandDetailDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate template;
		
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
			this.jdbcTemplate=jdbcTemplate;
		}
		
		@Autowired
		public void setDataSource(DataSource dataSource){
			this.jdbcTemplate=new JdbcTemplate(dataSource);
			this.template = new NamedParameterJdbcTemplate(dataSource);
		}


	@Override
	public void save(HouseLandDetailModel h) {
		String query="insert into house_and_land_detail (house_owner_id,land_house_id,family_id,ownership_type,house_number,land_unit,land_size,plot_num,sheet_num,district_uni,mun_vc_uni,ward_no_uni,moth_num_uni,kitta_num_uni,land_legacy_address,land_current_district,land_current_mun_vc,ward_no,tole,house_construction_type) values ()";
		jdbcTemplate.update(query);
	}

	public HouseLandDetailModel getSpecificHouseLand(String id) {
		String query="select * from house_and_land_detail where house_owner_id='"+id+"'";
		return jdbcTemplate.queryForObject(query, new HouseLandMapper());
	}
	
	public static final class HouseLandMapper implements RowMapper<HouseLandDetailModel>{

		@Override
		public HouseLandDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseLandDetailModel h=new HouseLandDetailModel();
			return h;
		}
		}

}
