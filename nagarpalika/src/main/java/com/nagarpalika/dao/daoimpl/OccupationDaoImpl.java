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

import com.nagarpalika.dao.OccupationDao;
import com.nagarpalika.model.OccupationModel;

@Repository
public class OccupationDaoImpl implements OccupationDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public void save(OccupationModel o) {
		String query = "insert into occupation_type (occupation_type, record_status, inputter, authorizer, date_time, curr_number) values ('"
				+ o.getOccupation_type() + "','" + o.getRecord_status() + "','"
				+ o.getInputter() + "','" + o.getAuthorizer() + "',now(),1)";
		jdbcTemplate.update(query);
	}

	public List<OccupationModel> findAll() {
		String query = "select * from occupation_type";
		return jdbcTemplate.query(query, new OccupationMapper());
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
		return jdbcTemplate.queryForObject(query, new OccupationMapper());
	}

	public void update(OccupationModel o, String id) {
		String query = "update occupation_type set occupation_type='"
				+ o.getOccupation_type() + "', record_status='" + o.getRecord_status() + "', inputter='"
				+ o.getInputter() + "', authorizer='" + o.getAuthorizer() + "', date_time=now() where occu_id='" + id + "'";
		jdbcTemplate.update(query);

	}

	@Override
	public void delete(String id) {
		String query = "delete from occupation_type where occu_id='" + id + "'";
		jdbcTemplate.update(query);
	}


}
