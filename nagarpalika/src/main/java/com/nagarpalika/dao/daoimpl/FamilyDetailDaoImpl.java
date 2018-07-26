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

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.RelationModel;

@Repository
public class FamilyDetailDaoImpl implements FamilyDetailDao {
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

	public int save(FamilyDetailModel f) {
		String query = "insert into family_detail (house_owner_id, fname, mname, lname, relation, marital_status, dob_nep ,disable_type, occupation_id, gender, date_time,inputter, curr_number) values ( :houseOwnerDetailModel.house_owner_id, :fname, :mname, :lname, :relationModel.relation, :marital_status, :dob_nep , :disableTypeModel.disable_type, :occupationModel.occupation_id, :gender, now(),:inputter,1)";
		return template.update(query, new BeanPropertySqlParameterSource(f));
	}

	public List<FamilyDetailModel> getFamilyDetail() {
		String query = "select * from family_detail";
		return jdbcTemplate.query(query, new FamilyDetailRowMapper());
	}

	public FamilyDetailModel findById(String id) {
		String query = "select * from family_detail where family_detail_id = ?";
		FamilyDetailModel familyDetailModel = jdbcTemplate.queryForObject(query, new Object[] { id },
				new FamilyDetailRowMapper());
		return familyDetailModel;
	}

	public int findMax() {
		String query = "select max(family_detail_id) from family_detail";
		return template.queryForInt(query, new BeanPropertySqlParameterSource(FamilyDetailModel.class));
	}

	public void update(FamilyDetailModel f, String id) {
		String query = "update family_detail set house_owner_id= :houseOwnerDetailModel.house_owner_id, inputter= :inputter,fname= :fname, mname= :mname, lname = :lname, relation= :relationModel.relation, marital_status= :marital_status, dob_nep= :dob_nep, disable_type = :disableTypeModel.disable_type, occupation_id= :occupationModel.occupation_id, gender= :gender, date_time=now() where family_detail_id='"+ id + "'";
		template.update(query, new BeanPropertySqlParameterSource(f));
	}

	public void delete(String id) {
		String query = "delete from family_detail where family_detail_id = ?";
		jdbcTemplate.update(query, new Object[] { id });
	}

	public class FamilyDetailRowMapper implements RowMapper<FamilyDetailModel> {
		@Override
		public FamilyDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseOwnerDetailModel houseOwnerDetailModel = (new BeanPropertyRowMapper<HouseOwnerDetailModel>(
					HouseOwnerDetailModel.class)).mapRow(rs, rowNum);
			FamilyDetailModel familyDetailModel = (new BeanPropertyRowMapper<FamilyDetailModel>(
					FamilyDetailModel.class)).mapRow(rs, rowNum);
			OccupationModel occupationModel = (new BeanPropertyRowMapper<OccupationModel>(OccupationModel.class))
					.mapRow(rs, rowNum);
			DisableTypeModel disableTypeModel = (new BeanPropertyRowMapper<DisableTypeModel>(DisableTypeModel.class))
					.mapRow(rs, rowNum);
			RelationModel relationModel = (new BeanPropertyRowMapper<RelationModel>(RelationModel.class))
					.mapRow(rs, rowNum);
			familyDetailModel.setHouseOwnerDetailModel(houseOwnerDetailModel);
			familyDetailModel.setOccupationModel(occupationModel);
			familyDetailModel.setDisableTypeModel(disableTypeModel);
			familyDetailModel.setRelationModel(relationModel);
			return familyDetailModel;
		}
	}

	@Override
	public List<FamilyDetailModel> findByHouseOwnerId(String id) {
		String query = "select * from family_detail where house_owner_id='"+id+"'";
		return template.query(query, new FamilyDetailRowMapper());
	}

}
