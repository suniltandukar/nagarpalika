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

@Repository
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
			b.setAddress(rs.getString("address"));
			b.setEmail(rs.getString("email"));
			b.setFax(rs.getString("fax"));
			b.setCompany_id(rs.getString("company_id"));
			b.setPhone(rs.getString("phone"));
			
			
			return b;
		}
		
	}

	@Override
	public void insertBranch(BranchModel bm) {
		String query="insert into branchtbl(company_id,name,address,phone,fax,email) values('"+bm.getCompany_id()+"','"+bm.getName()+"','"+bm.getAddress()+"','"+bm.getPhone()+"','"+bm.getFax()+"','"+bm.getEmail()+"')";
		jdbcTemplate.update(query);
	}

	@Override
	public BranchModel editBranch(String branch_id) {

		String query="select * from branchtbl where branch_id='"+branch_id+"'";
		return jdbcTemplate.queryForObject(query, new BranchMapper());
	}

	@Override
	public void updateBranch(String branch_id, BranchModel bm) {
		String sql="update branchtbl set company_id='"+bm.getCompany_id()+"', name='"+bm.getName()+"', address='"+bm.getAddress()+"',phone='"+bm.getPhone()+"', fax='"+bm.getFax()+"', email='"+bm.getEmail()+"'";
		jdbcTemplate.update(sql);
		
	}

}
