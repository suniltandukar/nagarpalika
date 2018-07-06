package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.model.DocumentTypeDetailModel;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {
	@Autowired
    private DataSource dataSource;

	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	public void save(DocumentTypeDetailModel d) {
		String query="insert into id_type_detail (id_type, description, inputter, authorizer, date_time, curr_number) values (:id_type, :description, :inputter, :authorizer, :date_time, :curr_number)";
		template.update(query, getSqlParameterByModel(d));
	

	}
	private SqlParameterSource getSqlParameterByModel(DocumentTypeDetailModel d) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id_type", d.getId_type());
		paramSource.addValue("description", d.getDescription());
		paramSource.addValue("inputter", d.getInputter());
		paramSource.addValue("authorizer", d.getAuthorizer());
		paramSource.addValue("date_time", d.getDate_time());
		paramSource.addValue("curr_number", d.getCurr_number());
		return paramSource;
		
	}
	public static final class DocumentTypeMapper implements RowMapper<DocumentTypeDetailModel>{

		@Override
		public DocumentTypeDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			DocumentTypeDetailModel d=new DocumentTypeDetailModel();
			d.setId_type(rs.getString("id_type"));
			d.setDescription(rs.getString("description"));
			d.setAuthorizer(rs.getString("authorizer"));
			d.setCurr_number(rs.getString("curr_number"));
			d.setDate_time(rs.getString("date_time"));
			d.setInputter(rs.getString("inputter"));
			return d;
		}
		}

	public List<DocumentTypeDetailModel> getDocumentType() {
		String query="select * from id_type_detail";
		return template.query(query, new DocumentTypeMapper());
	}
	
	
	public DocumentTypeDetailModel getSpecificDocumentType(String id) {
		String query="select * from id_type_detail where id_type= '"+id+"'";
		return template.queryForObject(query, getSqlParameterByModel(null),new DocumentTypeMapper());
	}

	public void update(DocumentTypeDetailModel d, String id) {
		String query="update id_type_detail set id_type= :id_type, description= :description, inputter= :inputter, authorizer= :authorizer, date_time= :date_time, curr_number= :curr_number where id_type='"+id+"'";
		template.update(query,getSqlParameterByModel(d));
		
	}

	public void delete(String id) {
		String query="delete from id_type_detail where id_type='"+id+"'";
		template.update(query,getSqlParameterByModel(null));
		
	}

}
