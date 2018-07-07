package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.HouseOwnerDao;
import com.nagarpalika.model.HouseHoldDetailModel;

@Repository
public class HouseOwnerDaoImpl implements HouseOwnerDao {
	private NamedParameterJdbcTemplate template;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public List<HouseHoldDetailModel> findAll() {
		String query="select * from house_owner_detail";
		return template.query(query, new BeanPropertySqlParameterSource(new HouseHoldDetailModel()), new HouseOwnerMapper());
	}
	
	public static final class HouseOwnerMapper implements RowMapper<HouseHoldDetailModel>{

		@Override
		public HouseHoldDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseHoldDetailModel h = new HouseHoldDetailModel();
			h.setHouse_owner_id(rs.getString("house_owner_id"));
			h.setHouse_owner_fname(rs.getString("house_owner_fname"));
			h.setHouse_owner_mname(rs.getString("house_owner_mname"));
			h.setHouse_owner_lname(rs.getString("house_owner_lname"));
			return h;
		}
		
	}

}
