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

import com.nagarpalika.dao.RoleDao;
import com.nagarpalika.model.RoleModel;
import com.nagarpalika.model.UserModel;


@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	

	private SqlParameterSource getSqlParameterByModel(RoleModel role) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", role.getName());
		paramSource.addValue("roles", role.getRoles());
		return paramSource;
	}

	
	public List<RoleModel> getRoles() {
		String sql = "select * from roleindex";
		return template.query(sql, new RoleMapper());
	}
	
	public static final class RoleMapper implements RowMapper<RoleModel>{

		@Override
		public RoleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleModel r = new RoleModel();
			r.setName(rs.getString("name"));
			r.setRoles(rs.getString("roles"));
			return r;
		}
		
	}

}
