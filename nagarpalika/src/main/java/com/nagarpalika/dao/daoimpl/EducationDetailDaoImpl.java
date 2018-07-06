package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.DocumentTypeDetailModel;
import com.nagarpalika.model.EducationDetailModel;

@Repository
public class EducationDetailDaoImpl implements EducationDetailDao {
	
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	
	public void save(EducationDetailModel e){
		String query="insert into education_detail(edu_id, education_type, record_status, inputter, authorizer, date_time, curr_number) values (:edu_id, :education_type, :record_status, :inputter, :authorizer, :date_time, :curr_number)";
		try{
		template.update(query,getSqlParameterByModel(e));
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}

	public List<EducationDetailModel> getEducationDetail() {
		String query="select * from education_detail";
		return template.query(query, new EducationDetailMapper());
		
	}
	public EducationDetailModel getEducationSpecificDetail(String id) {
		String query="select * from education_detail where edu_id='"+id+"'";
		return template.queryForObject(query, getSqlParameterByModel(null),new EducationDetailMapper());
		
	}
	public static final class EducationDetailMapper implements RowMapper<EducationDetailModel>{

		@Override
		public EducationDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			EducationDetailModel e=new EducationDetailModel();
			e.setEdu_id(rs.getString("edu_id"));
			e.setEducation_type(rs.getString("education_type"));
			e.setAuthorizer(rs.getString("authorizer"));
			e.setCurr_number(rs.getString("curr_number"));
			e.setDate_time(rs.getString("date_time"));
			e.setInputter(rs.getString("inputter"));
			e.setRecord_status(rs.getString("record_status"));
			return e;
		}
		}
	public void update(EducationDetailModel e, String id) {
		String query="update education_detail set education_type= :education_type, record_status= :record_status where edu_id='"+id+"'";
		template.update(query,getSqlParameterByModel(e));
	}

	public void delete(String id) {
		String query="delete from education_detail where edu_id='"+id+"'";
		template.update(query, getSqlParameterByModel(null));
		
	}
	private SqlParameterSource getSqlParameterByModel(EducationDetailModel e) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("authorizer", e.getAuthorizer());
		return paramSource;
	}
	

}
