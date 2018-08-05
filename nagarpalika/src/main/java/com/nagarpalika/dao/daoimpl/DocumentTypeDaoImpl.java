package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.model.DocumentTypeDetailModel;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	private final MapSqlParameterSource param = new MapSqlParameterSource();
		
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
			this.jdbcTemplate=jdbcTemplate;
		}
		
		@Autowired
		public void setDataSource(DataSource dataSource){
			this.jdbcTemplate=new JdbcTemplate(dataSource);
			this.template = new NamedParameterJdbcTemplate(dataSource);
		}

	public void save(DocumentTypeDetailModel d) {
		String query="insert into id_type_detail (id_type, description, inputter, date_time, curr_number) values (:id_type, :description, :inputter, now(), '1')";
		template.update(query, new BeanPropertySqlParameterSource(d));
	}

	public static final class DocumentTypeMapper implements RowMapper<DocumentTypeDetailModel>{

		@Override
		public DocumentTypeDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			DocumentTypeDetailModel d=new DocumentTypeDetailModel();
			d.setId_type(rs.getString("id_type"));
			d.setDescription(rs.getString("description"));
			d.setAuthorizer(rs.getString("authorizer"));
			d.setCurr_number(rs.getInt("curr_number"));
			d.setDate_time(rs.getString("date_time"));
			d.setInputter(rs.getString("inputter"));
			return d;
		}
		}

	public List<DocumentTypeDetailModel> getDocumentType() {
		String query="select * from id_type_detail";
		try{
			
			return template.query(query, new BeanPropertySqlParameterSource(new DocumentTypeDetailModel()),new DocumentTypeMapper());
		}
		catch(EmptyResultDataAccessException e){
			System.out.println(e);
			return null;
		}
		
	}
	
	
	
	public DocumentTypeDetailModel getSpecificDocumentType(String id) {
		String query="select * from id_type_detail where id_type= :id";
		
		param.addValue("id", id);
		return template.queryForObject(query, param,new DocumentTypeMapper());
	}

	public void update(DocumentTypeDetailModel d, String id) {
		String query="update id_type_detail set id_type= :id_type, description= :description, inputter= :inputter, date_time= now() where id_type='"+id+"'";
		template.update(query,new BeanPropertySqlParameterSource(d));
		
	}

	public void delete(String id) {
		String query="delete from id_type_detail where id_type= :id";
		param.addValue("id", id);
		template.update(query,param);
		
	}

}
