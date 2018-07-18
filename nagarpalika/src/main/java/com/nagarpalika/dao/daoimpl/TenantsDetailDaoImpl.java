package com.nagarpalika.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarpalika.dao.TenantsDetailDao;
import com.nagarpalika.dao.daoimpl.HouseFacilityDaoImpl.HouseFacilityRowMapper;
import com.nagarpalika.model.DrinkingWaterTypeModel;
import com.nagarpalika.model.HouseFacilityDetailModel;
import com.nagarpalika.model.HouseOwnerDetailModel;
import com.nagarpalika.model.OccupationModel;
import com.nagarpalika.model.TenantDetailModel;

@Repository
public class TenantsDetailDaoImpl implements TenantsDetailDao {
	private NamedParameterJdbcTemplate template;
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void SetDataSourceTag(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(TenantDetailModel t) {
		String query = "insert into tenants_detail (house_owner_id, land_house_id, tenant_name, tenant_address, occu_id, phone_number, identity, identity_number, tenant_nos, date_time, curr_number,inputter, company_name, owner, register_number, register_date, license_provider, phone, business_type, rented_purpose) values (:houseOwnerDetailModel.house_owner_id, :land_house_id, :tenant_name, :tenant_address, :occupationModel.occu_id, :phone_number, :identity, :identity_number, :tenant_nos, now(), 1,:inputter, :company_name, :owner, :register_number, :register_date, :license_provider, :phone, :business_type, :rented_purpose)";
		int value = template.update(query, new BeanPropertySqlParameterSource(t));
		return value;
	}

	@Override
	public TenantDetailModel findById(String id) {
		String query = "select * from tenants_detail where tenants_id = '"+id+"'";
		return template.queryForObject(query, new BeanPropertySqlParameterSource(TenantDetailModel.class),
				new TenantsRowMapper());
	}

	@Override
	public int findMax() {
		String query = "select max(tenants_id) as tenants_id from tenants_detail";
		int max_value = template.queryForObject(query,
				new BeanPropertySqlParameterSource(TenantDetailModel.class), Integer.class);
		return max_value;
	}

	@Override
	public void delete(String id) {
		String query = "delete from tenants_detail where tenants_id = ?";
		jdbcTemplate.update(query, new Object[] { id });

	}

	@Override
	public void update(TenantDetailModel t, String id) {
		String query = "update tenants_detail set house_owner_id=:houseOwnerDetailModel.house_owner_id, land_house_id=:land_house_id, inputter=:inputter,tenant_name=:tenant_name, tenant_address=:tenant_address, occu_id=:occupationModel.occu_id, phone_number=:phone_number, identity=:identity, identity_number=:identity_number, tenant_nos=:tenant_nos, date_time=now(), company_name=:company_name, owner=:owner, register_number=:register_number, register_date=:register_date, license_provider=:license_provider, phone=:phone, business_type=:business_type, rented_purpose=:rented_purpose where tenants_id = '"+id+"'";
		template.update(query, new BeanPropertySqlParameterSource(t));

	}

	@Override
	public List<TenantDetailModel> findAll() {
		String query = "select * from tenants_detail";
		return template.query(query, new TenantsRowMapper());
	}
	public class TenantsRowMapper implements RowMapper<TenantDetailModel> {
		@Override
		public TenantDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			HouseOwnerDetailModel houseOwnerDetailModel = (new BeanPropertyRowMapper<HouseOwnerDetailModel>(
					HouseOwnerDetailModel.class)).mapRow(rs, rowNum);
			OccupationModel occupationModel = (new BeanPropertyRowMapper<OccupationModel>(
					OccupationModel.class)).mapRow(rs, rowNum);
			TenantDetailModel tenantDetailModel = (new BeanPropertyRowMapper<TenantDetailModel>(
					TenantDetailModel.class)).mapRow(rs, rowNum);
			
			tenantDetailModel.setHouseOwnerDetailModel(houseOwnerDetailModel);
			tenantDetailModel.setOccupationModel(occupationModel);
			return tenantDetailModel;
		}

	}

}
