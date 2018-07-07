package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.RelationDao;
import com.nagarpalika.model.RelationModel;

@Repository
public class RelationDaoImpl implements RelationDao {
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<RelationModel> findAll() {
		String query="select * from relationtbl";
		try{
			return template.query(query, new BeanPropertySqlParameterSource(new RelationModel()), new RelationMapper());
		}
		catch(EmptyResultDataAccessException e){
			System.out.println(e);
			return null;
		}
	}
	public static final class RelationMapper implements RowMapper<RelationModel> {

		@Override
		public RelationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			RelationModel r = new RelationModel();
			r.setName(rs.getString("name"));
			r.setRelation_id(rs.getString("relation_id"));
			return r;
		}
		
	}

}
