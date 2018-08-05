package com.nagarpalika.model;

import javax.validation.constraints.Size;

public class HouseOwnerDetailModel {
	
	@Size(max=5)
	private String house_owner_id;
	@Size(max=2)
	private String
	house_owner_fname;
	private String 
	house_owner_mname,
	house_owner_lname,
	marital_status,
	grand_father_name,
	father_name,
	spouse_name,
	house_number,
	permanent_address,
	permanent_address_district,
	permanent_address_mun_vc,
	permanent_address_ward_no,
	temporary_address,
	gender,
	dob_nep,
	phone_number, 
	mobile_no,
	email,
	education_status,
	occupation_id,
	disable_type,
	pan_number,
	record_status,
	company_id,
	branch_id,
	inputter,
	authorizer,
	date_time;
	private String curr_number;
private OwnerDetailModel ownerIdentityDetailModel;
	public String getHouse_owner_id() {
		return house_owner_id;
	}

	public void setHouse_owner_id(String house_owner_id) {
		this.house_owner_id = house_owner_id;
	}

	public String getHouse_owner_fname() {
		return house_owner_fname;
	}

	public void setHouse_owner_fname(String house_owner_fname) {
		this.house_owner_fname = house_owner_fname;
	}

	public String getHouse_owner_mname() {
		return house_owner_mname;
	}

	public void setHouse_owner_mname(String house_owner_mname) {
		this.house_owner_mname = house_owner_mname;
	}

	public String getHouse_owner_lname() {
		return house_owner_lname;
	}

	public void setHouse_owner_lname(String house_owner_lname) {
		this.house_owner_lname = house_owner_lname;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getGrand_father_name() {
		return grand_father_name;
	}

	public void setGrand_father_name(String grand_father_name) {
		this.grand_father_name = grand_father_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getSpouse_name() {
		return spouse_name;
	}

	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getPermanent_address_district() {
		return permanent_address_district;
	}

	public void setPermanent_address_district(String permanent_address_district) {
		this.permanent_address_district = permanent_address_district;
	}

	public String getPermanent_address_mun_vc() {
		return permanent_address_mun_vc;
	}

	public void setPermanent_address_mun_vc(String permanent_address_mun_vc) {
		this.permanent_address_mun_vc = permanent_address_mun_vc;
	}

	public String getPermanent_address_ward_no() {
		return permanent_address_ward_no;
	}

	public void setPermanent_address_ward_no(String permanent_address_ward_no) {
		this.permanent_address_ward_no = permanent_address_ward_no;
	}

	public String getTemporary_address() {
		return temporary_address;
	}

	public void setTemporary_address(String temporary_address) {
		this.temporary_address = temporary_address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob_nep() {
		return dob_nep;
	}

	public void setDob_nep(String dob_nep) {
		this.dob_nep = dob_nep;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation_status() {
		return education_status;
	}

	public void setEducation_status(String education_status) {
		this.education_status = education_status;
	}

	public String getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(String occupation_id) {
		this.occupation_id = occupation_id;
	}

	public String getDisable_type() {
		return disable_type;
	}

	public void setDisable_type(String disable_type) {
		this.disable_type = disable_type;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
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

	public OwnerDetailModel getOwnerIdentityDetailModel() {
		return ownerIdentityDetailModel;
	}

	public void setOwnerIdentityDetailModel(OwnerDetailModel ownerIdentityDetailModel) {
		this.ownerIdentityDetailModel = ownerIdentityDetailModel;
	}




	

	

	
	
}
