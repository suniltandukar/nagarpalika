package com.nagarpalika.dao.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nagarpalika.dao.EducationDetailDao;
import com.nagarpalika.model.EducationDetailModel;

public class EducationDetailDaoImpl implements EducationDetailDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	public void save(EducationDetailModel e){
		String query="insert into education_detail(edu_id, education_type, record_status, inputter, authorizer, date_time, curr_number) values ('"+e.getEdu_id()+"','"+e.getEducation_type()+"','"+e.getRecord_status()+"','"+e.getInputter()+"','"+e.getAuthorizer()+"','"+e.getDate_time()+"','"+e.getCurr_number()+"')";
		try{
		jdbcTemplate.update(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}

}
