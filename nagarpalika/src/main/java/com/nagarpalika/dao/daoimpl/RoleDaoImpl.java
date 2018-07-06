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

import com.nagarpalika.dao.RoleDao;
import com.nagarpalika.model.RoleModel;


@Repository
public class RoleDaoImpl implements RoleDao {
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

	
	public List<RoleModel> getRoles() {
		String sql = "select * from roleindex";
		return jdbcTemplate.query(sql, new RoleMapper());
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
