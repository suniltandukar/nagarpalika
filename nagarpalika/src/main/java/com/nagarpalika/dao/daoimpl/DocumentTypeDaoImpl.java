package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.model.DocumentTypeDetailModel;
import com.nagarpalika.model.EducationDetailModel;

public class DocumentTypeDaoImpl implements DocumentTypeDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void save(DocumentTypeDetailModel d) {
		String query="insert into id_type_detail (id_type, description, inputter, authorizer, date_time, curr_number) values ('"+d.getId_type()+"','"+d.getDescription()+"','"+d.getInputter()+"','"+d.getAuthorizer()+"','"+d.getDate_time()+"','"+d.getCurr_number()+"')";
			jdbcTemplate.update(query);
	

	}

	public List<DocumentTypeDetailModel> getDocumentType() {
		String query="select * from id_type_detail";
		return jdbcTemplate.query(query, new DocumentTypeMapper());
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

	public DocumentTypeDetailModel getSpecificDocumentType(String id) {
		String query="select * from id_type_detail where id_type='"+id+"'";
		return jdbcTemplate.queryForObject(query, new DocumentTypeMapper());
	}

	public void update(DocumentTypeDetailModel d, String id) {
		String query="update id_type_detail set id_type='"+d.getId_type()+"', description='"+d.getDescription()+"', inputter='"+d.getInputter()+"', authorizer='"+d.getAuthorizer()+"', date_time='"+d.getDate_time()+"', curr_number='"+d.getCurr_number()+"' where id_type='"+id+"'";
		jdbcTemplate.update(query);
		
	}

	public void delete(String id) {
		String query="delete from id_type_detail where id_type='"+id+"'";
		jdbcTemplate.update(query);
		
	}

}
