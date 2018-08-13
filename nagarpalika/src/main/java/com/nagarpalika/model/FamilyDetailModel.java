package com.nagarpalika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
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
	private OccupationModel occupation_detail;
	private HouseOwnerDetailModel house_owner_detail;
	private DisableTypeModel disabledtype;
	private RelationModel relationtbl;
	
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
	
	public OccupationModel getOccupation_detail() {
		return occupation_detail;
	}
	public void setOccupation_detail(OccupationModel occupation_detail) {
		this.occupation_detail = occupation_detail;
	}
	public HouseOwnerDetailModel getHouse_owner_detail() {
		return house_owner_detail;
	}
	public void setHouse_owner_detail(HouseOwnerDetailModel house_owner_detail) {
		this.house_owner_detail = house_owner_detail;
	}
	public DisableTypeModel getDisabledtype() {
		return disabledtype;
	}
	public void setDisabledtype(DisableTypeModel disabledtype) {
		this.disabledtype = disabledtype;
	}
	public RelationModel getRelationtbl() {
		return relationtbl;
	}
	public void setRelationtbl(RelationModel relationtbl) {
		this.relationtbl = relationtbl;
	}
	
	

}
