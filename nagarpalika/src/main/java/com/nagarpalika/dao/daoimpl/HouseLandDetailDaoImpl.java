package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseLandDetailDao;
import com.nagarpalika.model.DocumentTypeDetailModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseLandDetailModel;

@Repository
public class HouseLandDetailDaoImpl implements HouseLandDetailDao {
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	
	private SqlParameterSource getSqlParameterByModel(HouseLandDetailModel h) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("authorizer", h.getAuthorizer());
		paramSource.addValue("branchi_id", h.getBranch_id());
		paramSource.addValue("company_id", h.getCompany_id());
		paramSource.addValue("completion_approved_by", h.getCompletion_approved_by());
		paramSource.addValue("construction_completion_approval_date", h.getConstruction_completion_approval_date());
		paramSource.addValue("construction_completion_date", h.getConstruction_completion_date());
		paramSource.addValue("construction_start_date", h.getConstruction_start_date());
		paramSource.addValue("curr_number", h.getCurr_number());
		paramSource.addValue("date_time", h.getDate_time());
		paramSource.addValue("district_uni", h.getDistrict_uni());
		paramSource.addValue("family_id", h.getFamily_id());
		paramSource.addValue("house_area", h.getHouse_area());
		paramSource.addValue("house_area_unit", h.getHouse_area_unit());
		paramSource.addValue("house_construction_type", h.getHouse_construction_type());
		paramSource.addValue("house_floor_count", h.getHouse_floor_count());
		paramSource.addValue("house_floor_rented_count", h.getHouse_floor_rented_count());
		return paramSource;
	}
	@Override
	public void save(HouseLandDetailModel h) {
		String query = "insert into house_and_land_detail (house_owner_id,land_house_id,family_id,ownership_type,house_number,land_unit,land_size,plot_num,sheet_num,district_uni,mun_vc_uni,ward_no_uni,moth_num_uni,kitta_num_uni,land_legacy_address,land_current_district,land_current_mun_vc,ward_no,tole,house_construction_type) values ( :house_owner_id, :land_house_id, :family_id, :ownership_type, :house_number, :land_unit, :land_size, :plot_num, :sheet_num, :district_uni, :mun_vc_uni, :ward_no_uni, :moth_num_uni, :kitta_num_uni, :land_legacy_address, :land_current_district, :land_current_mun_vc, :ward_no,tole, :house_construction_type)";
		template.update(query, getSqlParameterByModel(h));
	}

	public HouseLandDetailModel getSpecificHouseLand(String id) {
		String query = "select * from house_and_land_detail where house_owner_id='" + id + "'";
		HouseLandDetailModel houseLandDetail = template.queryForObject(query, getSqlParameterByModel(null),
				new HouseLandMapper());
		try {
			return houseLandDetail;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;

		}
	}

	

	public static final class HouseLandMapper implements RowMapper<HouseLandDetailModel> {

		@Override
		public HouseLandDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseLandDetailModel h = new HouseLandDetailModel();
			return h;
		}
	}

}
