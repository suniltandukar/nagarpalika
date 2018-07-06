package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
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
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	
	
	public List<DisableTypeModel> getDisableType() {
		String query="select * from disabledtype";
		return template.query(query, new DisableTypeMapper());
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
