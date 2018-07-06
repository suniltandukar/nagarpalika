package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;

@Repository
public class FamilyDetailDaoImpl implements FamilyDetailDao {
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	

	public void save(FamilyDetailModel f) {
		String query = "insert into family_detail (house_owner_id, house_owner_fname, house_owner_mname, house_owner_lname, relation, name, marital_status, dob_nep ,disable_type, occupation_id, gender, date_time) values (:house_owner_id, :house_owner_fname, :house_owner_mname, :house_owner_lname, :relation, :name, :marital_status, :dob_nep , :disable_type, :occupation_id, :gender, NOW())";
		try{
			template.update(query, getSqlParameterByModel(f));
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public List<FamilyDetailModel> getFamilyDetail() {
		String query = "select * from family_detail";
		return template.query(query, new FamilyDetailMapper());
	}

	public FamilyDetailModel getSpecificFamilyDetail(String id) {
		String query = "select * from family_detail where house_owner_id = '" + id + "'";
		return template.queryForObject(query, getSqlParameterByModel(null) ,new FamilyDetailMapper());
	}

	public void update(FamilyDetailModel f, String id) {
		String query = "update family_detail set house_owner_id= :house_owner, house_owner_fname= :house_owner_fname, relation= :relation, name= :name, marital_status= :marital_status, dob_nep= :dob_nep, disable_type = :disable_type, occupation_id= :occupation_id, gender= :gender where house_owner_id='" + id + "'";
		template.update(query, getSqlParameterByModel(f));
	}

	public void delete(String id) {
		String query = "delete from family_detail where house_owner_id = '" + id + "'";
		template.update(query, getSqlParameterByModel(null));
	}

	public static final class FamilyDetailMapper implements RowMapper<FamilyDetailModel> {

		@Override
		public FamilyDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			FamilyDetailModel f = new FamilyDetailModel();
			f.setHouse_owner_id(rs.getString("house_owner_id"));
			f.setHouse_owner_fname(rs.getString("house_owner_fname"));
			f.setRelation(rs.getString("relation"));
			f.setName(rs.getString("name"));
			f.setMarital_status(rs.getString("marital_status"));
			f.setDob_nep(rs.getString("dob_nep"));
			return f;
		}
	}

	private SqlParameterSource getSqlParameterByModel(FamilyDetailModel f) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("house_owner_id", f.getHouse_owner_id());
		paramSource.addValue("house_owner_fname", f.getHouse_owner_fname());
		paramSource.addValue("house_owner_mname", f.getHouse_owner_mname());
		paramSource.addValue("house_owner_lname", f.getHouse_owner_lname());
		paramSource.addValue("relation", f.getRelation());
		paramSource.addValue("name", f.getName());
		paramSource.addValue("marital_status", f.getMarital_status());
		paramSource.addValue("dob_nep", f.getDob_nep());
		paramSource.addValue("disable_type", f.getDisable_type());
		paramSource.addValue("occupation_id", f.getOccupation_id());
		paramSource.addValue("gender", f.getGender());
		return paramSource;
	}

	

}
