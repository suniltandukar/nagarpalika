package com.nagarpalika.model;


public class FamilyDetailModel {
	
private int family_detail_id;
	private String marital_status,
	dob_nep,
	occupation_id,
	gender,
	inputter,
	authorizer,
	date_time,
	fname,
	mname,
	lname,curr_number;
	private OccupationModel occupationModel;
	private HouseOwnerDetailModel houseOwnerDetailModel;
	private DisableTypeModel disableTypeModel;
	private RelationModel relationModel;
	
	public int getFamily_detail_id() {
		return family_detail_id;
	}
	public void setFamily_detail_id(int family_detail_id) {
		this.family_detail_id = family_detail_id;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public DisableTypeModel getDisableTypeModel() {
		return disableTypeModel;
	}
	public void setDisableTypeModel(DisableTypeModel disableTypeModel) {
		this.disableTypeModel = disableTypeModel;
	}
	public RelationModel getRelationModel() {
		return relationModel;
	}
	public void setRelationModel(RelationModel relationModel) {
		this.relationModel = relationModel;
	}
	
	

}
