package com.nagarpalika.model;


public class FamilyDetailModel {
	
private int family_detail_id;
	private String house_owner_fname, house_owner_mname, house_owner_lname,relation,
	marital_status,
	dob_nep,
	disable_type,
	occupation_id,
	gender,
	inputter,
	authorizer,
	date_time,
	curr_number;
	private OccupationModel occupationModel;
	private HouseOwnerDetailModel houseOwnerDetailModel;
	
	public int getFamily_detail_id() {
		return family_detail_id;
	}

	public void setFamily_detail_id(int family_detail_id) {
		this.family_detail_id = family_detail_id;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getDob_nep() {
		return dob_nep;
	}

	public void setDob_nep(String dob_nep) {
		this.dob_nep = dob_nep;
	}

	public String getDisable_type() {
		return disable_type;
	}

	public void setDisable_type(String disable_type) {
		this.disable_type = disable_type;
	}

	public String getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(String occupation_id) {
		this.occupation_id = occupation_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public OccupationModel getOccupationModel() {
		return occupationModel;
	}

	public void setOccupationModel(OccupationModel occupationModel) {
		this.occupationModel = occupationModel;
	}

	public HouseOwnerDetailModel getHouseOwnerDetailModel() {
		return houseOwnerDetailModel;
	}

	public void setHouseOwnerDetailModel(HouseOwnerDetailModel houseOwnerDetailModel) {
		this.houseOwnerDetailModel = houseOwnerDetailModel;
	}
	
	

}
