package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarpalika.dao.UserDao;
import com.nagarpalika.extras.Generator;
import com.nagarpalika.model.BranchModel;
import com.nagarpalika.model.UserModel;


@Repository
public class UserDaoImpl implements UserDao {
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
	

	public boolean verifyUser(UserModel user) {

		boolean userexists = false;

		String sql = "SELECT COUNT(*) FROM usertbl WHERE username='" + user.getUsername() + "' AND password='"
				+ user.getPassword() + "' and staffCode='" + user.getStaffCode() + "'";
		System.out.println(sql);
		int rowcount = template.queryForObject(sql, new BeanPropertySqlParameterSource(user),Integer.class);
		System.out.println(rowcount);
		if (rowcount == 1) {
			userexists = true;
		}
		return userexists;

	}

	public UserModel getUserDetails(UserModel user) {
		String sql = "SELECT * FROM usertbl join branchtbl using(branch_id) WHERE usertbl.username= :username AND usertbl.password= :password and usertbl.staffCode= staffCode";
		return template.queryForObject(sql,new BeanPropertySqlParameterSource(user),new UserMapper());
	}

	public UserModel getSpecificUserDetails(String userid) {
		String sql = "SELECT * FROM usertbl WHERE userid = '" + userid + "'";
		return template.queryForObject(sql, new BeanPropertySqlParameterSource(null),new UserMapper());
	}

	public boolean insertUser(UserModel u) {
		Generator g = new Generator();
		String functionAllowed = g.addHash(u.getFunctionAllowed());
		u.setFunctionAllowed(functionAllowed);
		String query = "insert into usertbl(username,password,givenrole,fullName,post,staffCode,startDate,endDate,branchCode,functionAllowed,functionRestriction,branchAllowed,additionalFunctions) values( :username, :password, :givenrole, :fullName, :post, :staffCode, :startDate, :endDate,branchCode, :functionAllowed, :functionRestriction, :branchAllowed, :additionalFunctions)";
		int status = template.update(query, new BeanPropertySqlParameterSource(u));
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int updateUser(UserModel u){
		String sql = "update usertbl set username='"+u.getUsername()+"', givenrole='"+u.getGivenrole()+"',fullName='"+u.getFullName()+"',post='"+u.getPost()+"',staffCode='"+u.getStaffCode()+"',startDate='"+u.getStartDate()+"',endDate='"+u.getEndDate()+"',branchCode='"+u.getBranch().getBranch_id()+"',functionAllowed='"+u.getFunctionAllowed()+"',branchAllowed='"+u.getBranchAllowed()+"',additionalFunctions='"+u.getAdditionalFunctions()+"' where userid='"+u.getUserid()+"'";
		System.out.println(sql);
		return template.update(sql, new BeanPropertySqlParameterSource(u));
	}
	public static final class UserMapper implements RowMapper<UserModel> {

		@Override
		public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserModel user = new UserModel();
			BranchModel branch = new BranchModel();
			user.setStaffCode(rs.getString("staffCode"));
			user.setUserid(rs.getString("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getString("status"));
			user.setGivenrole(rs.getString("givenrole"));
			user.setFullName(rs.getString("fullName"));
			user.setPost(rs.getString("post"));
			user.setStartDate(rs.getString("startDate"));
			user.setEndDate(rs.getString("endDate"));
			user.setRoleName(rs.getString("roleName"));
			user.setFunctionAllowed(rs.getString("functionAllowed"));
			user.setFunctionRestriction(rs.getString("functionRestriction"));
			user.setBranchAllowed(rs.getString("branchAllowed"));
			user.setAdditionalFunctions(rs.getString("additionalFunctions"));
			user.setBranchAllowedFunctions(rs.getString("branchAllowedFunctions"));

			branch.setBranch_id(rs.getString("branch_id"));
			branch.setCompany_id(rs.getString("company_id"));
			user.setBranch(branch);

			return user;
		}

	}

	public List<UserModel> getUsers() {
		String sql = "SELECT * FROM usertbl join branchtbl using(branch_id)";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	/*public String sessionUsername(@SessionAttributes("userDetail") UserModel user){
		String username = "";
		if(user!=null){
			username = user.getUsername();
		}
		return username;
	}*/
}
