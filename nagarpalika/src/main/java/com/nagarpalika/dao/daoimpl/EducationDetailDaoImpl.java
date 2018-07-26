package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.EducationDetailModel;

@Repository
public class EducationDetailDaoImpl implements EducationDetailDao {
	
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
	
	public void save(EducationDetailModel e){
		String query="insert into education_detail(edu_id, education_type, inputter, date_time, curr_number) values ('"+e.getEdu_id()+"','"+e.getEducation_type()+"','"+e.getInputter()+"',now(),'1')";
		try{
		jdbcTemplate.update(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}

	public List<EducationDetailModel> getEducationDetail() {
		String query="select * from education_detail";
		return jdbcTemplate.query(query, new EducationDetailMapper());
		
	}
	public EducationDetailModel getEducationSpecificDetail(String id) {
		String query="select * from education_detail where edu_id='"+id+"'";
		return jdbcTemplate.queryForObject(query, new EducationDetailMapper());
		
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
		String query="update education_detail set education_type='"+e.getEducation_type()+"', inputter='"+e.getInputter()+"' where edu_id='"+id+"'";
		jdbcTemplate.update(query);
	}

	public void delete(String id) {
		String query="delete from education_detail where edu_id='"+id+"'";
		jdbcTemplate.update(query);
		
	}

}
