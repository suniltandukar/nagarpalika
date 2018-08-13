package com.nagarpalika.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.RestDao;
import com.nagarpalika.model.DisableTypeModel;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.model.FamilyDetailModel;
import com.nagarpalika.model.HouseConstructionTypeModel;
import com.nagarpalika.model.HouseHoldDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.RelationModel;

@Repository
public class RestDaoImpl implements RestDao {
	private NamedParameterJdbcTemplate template;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}


	@Override
	public List<OccupationModel> getOccupation() {
		String sql = "select occu_id, occupation_type from occupation_type";
		List<OccupationModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new OccupationModel()),new BeanPropertyRowMapper<OccupationModel>(OccupationModel.class));
		return list;
	}

	@Override
	public List<EducationDetailModel> getEducation() {
		String sql = "select edu_id, education_type from education_detail";
		List<EducationDetailModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new EducationDetailModel()),new BeanPropertyRowMapper<EducationDetailModel>(EducationDetailModel.class));
		return list;
	}

	@Override
	public List<DisableTypeModel> getDisableType() {
		String sql = "select id, typehead from disabledtype";
		List<DisableTypeModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new DisableTypeModel()),new BeanPropertyRowMapper<DisableTypeModel>(DisableTypeModel.class));
		return list;
	}

	@Override
	public List<RelationModel> getRelation() {
		String sql = "select relation_id, name from relationtbl";
		List<RelationModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new RelationModel()),new BeanPropertyRowMapper<RelationModel>(RelationModel.class));
		return list;
	}

	@Override
	public List<HouseHoldDetailModel> getHouseHoldDetail() {
		String sql = "select house_owner_id, house_owner_fname, house_owner_mname, house_owner_lname from house_owner_detail";
		List<HouseHoldDetailModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new HouseHoldDetailModel()),new BeanPropertyRowMapper<HouseHoldDetailModel>(HouseHoldDetailModel.class));
		return list;
	}

	@Override
	public List<FamilyDetailModel> getFamilyDetail() {
		String sql = "select family_detail_id, fname, mname, lname from family_detail";
		List<FamilyDetailModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new FamilyDetailModel()),new BeanPropertyRowMapper<FamilyDetailModel>(FamilyDetailModel.class));
		return list;
	}

	@Override
	public List<HouseConstructionTypeModel> getHouseConstruction() {
		String sql = "select construction_id, construction_name from constructiontypetbl";
		List<HouseConstructionTypeModel> list = template.query(sql ,new BeanPropertySqlParameterSource(new HouseConstructionTypeModel()),new BeanPropertyRowMapper<HouseConstructionTypeModel>(HouseConstructionTypeModel.class));
		return list;
	}
	
	

}
