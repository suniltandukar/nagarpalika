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

import com.nagarpalika.dao.FormDetailDao;
import com.nagarpalika.model.DisableTypeModel;

@Repository
public class FormDetailDaoImpl implements FormDetailDao {
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

	
	
	public List<DisableTypeModel> getDisableType() {
		String query="select * from disabledtype";
		return jdbcTemplate.query(query, new DisableTypeMapper());
	}
	
	public static final class DisableTypeMapper implements RowMapper<DisableTypeModel>{

		@Override
		public DisableTypeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			DisableTypeModel d = new DisableTypeModel();
			d.setId(rs.getInt("id"));
			d.setTypehead(rs.getString("typehead"));
			return d;
		}
		}

}
