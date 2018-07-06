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

import com.nagarpalika.dao.OccupationDao;
import com.nagarpalika.model.EducationDetailModel;
import com.nagarpalika.model.HouseLandDetailModel;
import com.nagarpalika.model.OccupationModel;

@Repository
public class OccupationDaoImpl implements OccupationDao {
	@Autowired
    private DataSource dataSource;
	private NamedParameterJdbcTemplate template;  
	  
	 @PostConstruct
	    private void postConstruct() {
	        template = new NamedParameterJdbcTemplate(dataSource);
	    }

	
	private SqlParameterSource getSqlParameterByModel(OccupationModel o) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("authorizer", o.getAuthorizer());
		return paramSource;
	}

	public void save(OccupationModel o) {
		String query = "insert into occupation_type (occu_id, occupation_type, record_status, inputter, authorizer, date_time, curr_number) values ( :occu_id, :occupation_type, :record_status, :inputter, :authorizer, :date_time, :curr_number)";
		template.update(query, getSqlParameterByModel(o));
	}

	public List<OccupationModel> findAll() {
		String query = "select * from occupation_type";
		return template.query(query, new OccupationMapper());
	}

	public static final class OccupationMapper implements RowMapper<OccupationModel> {

		@Override
		public OccupationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			OccupationModel o = new OccupationModel();
			o.setAuthorizer(rs.getString("authorizer"));
			o.setCurr_number(rs.getString("curr_number"));
			o.setDate_time(rs.getString("date_time"));
			o.setInputter(rs.getString("inputter"));
			o.setOccu_id(rs.getString("occu_id"));
			o.setOccupation_type(rs.getString("occupation_type"));
			o.setRecord_status(rs.getString("record_status"));
			return o;
		}
	}

	public OccupationModel findById(String id) {
		String query = "select * from occupation_type where occu_id='" + id + "'";
		return template.queryForObject(query, getSqlParameterByModel(null), new OccupationMapper());
	}

	public void update(OccupationModel o, String id) {
		String query = "update occupation_type set occu_id= :occu_id, occupation_type= :occupation_type, record_status= :record_status, inputter= :inputter, authorizer= :authorizer, date_time= :date_time, curr_number= :curr_number where occu_id='"
				+ id + "'";
		template.update(query, getSqlParameterByModel(o));

	}

	@Override
	public void delete(String id) {
		String query = "delete from occupation_type where occu_id='" + id + "'";
		template.update(query, getSqlParameterByModel(null));
	}

}
