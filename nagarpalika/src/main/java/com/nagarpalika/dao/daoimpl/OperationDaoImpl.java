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

import com.nagarpalika.dao.OperationDao;
import com.nagarpalika.model.UserModel;


@Repository
public class OperationDaoImpl implements OperationDao {
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
	
	
	public List<UserModel> getSystemDetails() {
		String sql = "select * from generalsettings";
		return jdbcTemplate.query(sql, new SystemDetailMapper());
	}
	public boolean updateGeneralSetting(UserModel user){
		boolean status=false;
		String sql="update generalsettings set description='"+user.getSettingsdescription()+"' where type='"+user.getSettingstype()+"'";
		int i=jdbcTemplate.update(sql);
		if(i>0){
			status=true;
		}
		return status;
	}
	public boolean insertTableDetail(String tablename,String columns, String value){
		boolean status=false;
		String sql="INSERT INTO "+tablename+" "+columns+"  VALUES ('"+value+"')";
		System.out.println(sql);
		int i=jdbcTemplate.update(sql);
		if(i>0){
			status=true;
		}
		return status;
	}
	public final static class SystemDetailMapper implements RowMapper<UserModel> {

		@Override
		public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserModel user = new UserModel();
			user.setSettingsid(rs.getString("settings_id"));
			user.setSettingstype(rs.getString("type"));
			user.setSettingsdescription(rs.getString("description"));
			return user;
		}
	}
	public boolean checkSubCode(String subjectcode){
		String sql="select count(subjectCode) from subjectlist where subjectCode='"+subjectcode+"'";
		int rowcount=jdbcTemplate.queryForObject(sql, Integer.class);
		if(rowcount==1){
			return true;
		}
		return false;
		
	}
	

}
