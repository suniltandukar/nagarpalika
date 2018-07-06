package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.UserDao;
import com.nagarpalika.extras.Generator;
import com.nagarpalika.model.BranchModel;
import com.nagarpalika.model.UserModel;


@Repository
public class UserDaoImpl implements UserDao {
	 @Autowired
	    private NamedParameterJdbcTemplate template;
	 
	    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	        return template;
	    }


	private SqlParameterSource getSqlParameterByModel(UserModel user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("additionalFunctions", user.getAdditionalFunctions());
		paramSource.addValue("branchAllowed", user.getBranchAllowed());
		paramSource.addValue("branchAllowedFunctions", user.getBranchAllowedFunctions());
		paramSource.addValue("endDate", user.getEndDate());
		paramSource.addValue("fullName", user.getFullName());
		paramSource.addValue("functionAllowed", user.getFunctionAllowed());
		paramSource.addValue("functionRestriction", user.getFunctionRestriction());
		paramSource.addValue("givenrole", user.getGivenrole());
		paramSource.addValue("password", user.getPassword());
		paramSource.addValue("post", user.getPost());
		paramSource.addValue("roleName", user.getRoleName());
		paramSource.addValue("settingsDescription", user.getSettingsdescription());
		paramSource.addValue("settingsid", user.getSettingsid());
		paramSource.addValue("settingstype", user.getSettingstype());
		paramSource.addValue("staffCode", user.getStaffCode());
		paramSource.addValue("startDate", user.getStartDate());
		paramSource.addValue("status", user.getStatus());
		paramSource.addValue("userid", user.getUserid());
		paramSource.addValue("username", user.getUsername());
		return paramSource;
	}

	public boolean verifyUser(UserModel user) {

		boolean userexists = false;

		String sql = "SELECT COUNT(*) FROM usertbl WHERE username= :username AND password= :password and staffCode= :staffCode";
		System.out.println(sql);
		int rowcount = template.queryForObject(sql, getSqlParameterByModel(user),Integer.class);
		System.out.println(rowcount);
		if (rowcount == 1) {
			userexists = true;
		}
		return userexists;

	}

	public UserModel getUserDetails(UserModel user) {
		String sql = "SELECT * FROM usertbl join branchtbl using(branch_id) WHERE usertbl.username= :username AND usertbl.password= :password and usertbl.staffCode= staffCode";
		return template.queryForObject(sql,getSqlParameterByModel(user),new UserMapper());
	}

	public UserModel getSpecificUserDetails(String userid) {
		String sql = "SELECT * FROM usertbl WHERE userid = '" + userid + "'";
		return template.queryForObject(sql, getSqlParameterByModel(null),new UserMapper());
	}

	public boolean insertUser(UserModel u) {
		Generator g = new Generator();
		String functionAllowed = g.addHash(u.getFunctionAllowed());
		u.setFunctionAllowed(functionAllowed);
		String query = "insert into usertbl(username,password,givenrole,fullName,post,staffCode,startDate,endDate,branchCode,functionAllowed,functionRestriction,branchAllowed,additionalFunctions) values( :username, :password, :givenrole, :fullName, :post, :staffCode, :startDate, :endDate,branchCode, :functionAllowed, :functionRestriction, :branchAllowed, :additionalFunctions)";
		int status = template.update(query, getSqlParameterByModel(u));
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int updateUser(UserModel u){
		String sql = "update usertbl set username= :username, givenrole= :givenrole,fullName= :fullName,post= :post,staffCode= :staffCode,startDate= :startDate,endDate= :endDate,branchCode= :branchCode,functionAllowed= :functionAllowed,branchAllowed= :branchAllowed,additionalFunctions= :additionalFunctions where userid= :userid";
		System.out.println(sql);
		return template.update(sql, getSqlParameterByModel(u));
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
		return template.query(sql, new UserMapper());
	}

}
