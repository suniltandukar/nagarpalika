package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.FamilyDetailDao;
import com.nagarpalika.model.FamilyDetailModel;

@Repository
public class FamilyDetailDaoImpl implements FamilyDetailDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	public void save(FamilyDetailModel f){
		String query="insert into family_detail (house_owner_id, house_owner_fname, relation, name, marital_status, dob_nep ,disable_type, occupation_id, gender, date_time) values ('"+f.getHouse_owner_id()+"', '"+f.getHouse_owner_fname()+"', '"+f.getRelation()+"','"+f.getName()+"','"+f.getMarital_status()+"','"+f.getDob_nep()+"','"+f.getDisable_type()+"','"+f.getOccupation_id()+"','"+f.getGender()+"', NOW())";
		jdbcTemplate.update(query);
	}
	
	public List<FamilyDetailModel> getFamilyDetail(){
		String query="select * from family_detail";
		return jdbcTemplate.query(query, new FamilyDetailMapper());
	}
	
	public FamilyDetailModel getSpecificFamilyDetail(String id){
		String query="select * from family_detail where house_owner_id = '"+id+"'";
		return jdbcTemplate.queryForObject(query, new FamilyDetailMapper());
	}
	
	public void update(FamilyDetailModel f, String id){
		String query="update family_detail set house_owner_id='"+f.getHouse_owner_id()+"', house_owner_fname='"+f.getHouse_owner_fname()+"', relation='"+f.getRelation()+"', name='"+f.getName()+"', marital_status='"+f.getMarital_status()+"', dob_nep='"+f.getDob_nep()+"', disable_type = '"+f.getDisable_type()+"', occupation_id='"+f.getOccupation_id()+"', gender='"+f.getGender()+"' where house_owner_id='"+id+"'";
		jdbcTemplate.update(query);
	}
	
	public void delete(String id){
		String query="delete from family_detail where house_owner_id = '"+id+"'";
		jdbcTemplate.update(query);
	}
	
	public static final class FamilyDetailMapper implements RowMapper<FamilyDetailModel>{

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

}
