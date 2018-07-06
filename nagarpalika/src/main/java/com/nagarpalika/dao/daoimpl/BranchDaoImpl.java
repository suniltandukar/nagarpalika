package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.BranchDao;
import com.nagarpalika.model.BranchModel;

@Repository("branchDao")
public class BranchDaoImpl implements BranchDao {
	 @Autowired
	    private NamedParameterJdbcTemplate template;
	 
	    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	        return template;
	    }


	public List<BranchModel> findAll() {
		String sql = "select * from branchtbl";
		return template.query(sql, new BranchMapper());
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
		//template.update(query);
	}

}
