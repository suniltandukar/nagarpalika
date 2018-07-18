package com.nagarpalika.model;

public class TenantDetailModel {
	private String tenants_id,
	land_house_id,
	tenant_name,
	tenant_address,
	phone_number,
	identity,
	identity_number,
	tenant_nos,
	record_status,
	company_id,
	branch_id,
	inputter,
	authorizer,
	date_time;
	private String company_name;
	private String owner;
	private String register_number;
	private String register_date;
	private String license_provider;
	private String phone;
	private String business_type;
	private String rented_purpose;
	private String curr_number;

	private HouseOwnerDetailModel houseOwnerDetailModel;
	private OccupationModel occupationModel;

	
	public String getTenants_id() {
		return tenants_id;
	}

	public void setTenants_id(String tenants_id) {
		this.tenants_id = tenants_id;
	}

	public String getLand_house_id() {
		return land_house_id;
	}

	public void setLand_house_id(String land_house_id) {
		this.land_house_id = land_house_id;
	}

	public String getTenant_name() {
		return tenant_name;
	}

	public void setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
	}

	public String getTenant_address() {
		return tenant_address;
	}

	public void setTenant_address(String tenant_address) {
		this.tenant_address = tenant_address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getTenant_nos() {
		return tenant_nos;
	}

	public void setTenant_nos(String tenant_nos) {
		this.tenant_nos = tenant_nos;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getInputter() {
		return inputter;
	}

	public void setInputter(String inputter) {
		this.inputter = inputter;
	}

	public String getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}


	public String getCurr_number() {
		return curr_number;
	}

	public void setCurr_number(String curr_number) {
		this.curr_number = curr_number;
	}

	public HouseOwnerDetailModel getHouseOwnerDetailModel() {
		return houseOwnerDetailModel;
	}

	public void setHouseOwnerDetailModel(HouseOwnerDetailModel houseOwnerDetailModel) {
		this.houseOwnerDetailModel = houseOwnerDetailModel;
	}

	public OccupationModel getOccupationModel() {
		return occupationModel;
	}

	public void setOccupationModel(OccupationModel occupationModel) {
		this.occupationModel = occupationModel;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRegister_number() {
		return register_number;
	}

	public void setRegister_number(String register_number) {
		this.register_number = register_number;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getLicense_provider() {
		return license_provider;
	}

	public void setLicense_provider(String license_provider) {
		this.license_provider = license_provider;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	public String getRented_purpose() {
		return rented_purpose;
	}

	public void setRented_purpose(String rented_purpose) {
		this.rented_purpose = rented_purpose;
	}
}
