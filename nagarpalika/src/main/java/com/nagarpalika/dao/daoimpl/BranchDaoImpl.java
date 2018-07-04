package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;


public class BranchDaoImpl implements BranchDao {
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public List<BranchModel> getBranches() {
		String sql = "select * from branchtbl";
		return jdbcTemplate.query(sql, new BranchMapper());
	}
	
	public static final class BranchMapper implements RowMapper<BranchModel>{

		@Override
		public BranchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			BranchModel b = new BranchModel();
			b.setBranch_id(rs.getString("branchId"));
			b.setName(rs.getString("branchName"));
			
			return b;
		}
		
	}

	@Override
	public void insertBranch(BranchModel bm) {
		String query="insert into branchtbl(company_id,name,address,phone,fax,email) values('"+bm.getCompany_id()+"','"+bm.getName()+"','"+bm.getAddress()+"','"+bm.getPhone()+"','"+bm.getFax()+"','"+bm.getEmail()+"')";
		jdbcTemplate.update(query);
	}

}
