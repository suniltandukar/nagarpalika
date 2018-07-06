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

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;

@Repository("branchDao")
public class BranchDaoImpl implements BranchDao {
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
	public List<BranchModel> findAll() {
		String sql = "select * from branchtbl";
		return jdbcTemplate.query(sql, new BranchMapper());
	}
	
	public static final class BranchMapper implements RowMapper<BranchModel>{

		@Override
		public BranchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			BranchModel b = new BranchModel();
			b.setBranch_id(rs.getString("branch_id"));
			b.setName(rs.getString("name"));
			b.setCompany_id(rs.getString("company_id"));
			b.setEmail(rs.getString("email"));
			b.setFax(rs.getString("fax"));
			b.setPhone(rs.getString("phone"));
			b.setAddress(rs.getString("address"));
			
			
			return b;
		}
		
	}

	@Override
	public void insertBranch(BranchModel bm) {
		String query="insert into branchtbl(company_id,name,address,phone,fax,email) values('"+bm.getCompany_id()+"','"+bm.getName()+"','"+bm.getAddress()+"','"+bm.getPhone()+"','"+bm.getFax()+"','"+bm.getEmail()+"')";
		jdbcTemplate.update(query);
	}

}
