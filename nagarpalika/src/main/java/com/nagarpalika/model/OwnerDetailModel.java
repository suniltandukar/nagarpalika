package com.nagarpalika.model;

import java.util.List;

public class OwnerDetailModel {
	
	List<String> owner_identity_id,id_type,id_number,issue_date,expiry_date,issued_by,record_status,inputter,authorizer,date_time;
String house_owner_id;
private String curr_number;	

	public String getHouse_owner_id() {
	return house_owner_id;
}

public void setHouse_owner_id(String house_owner_id) {
	this.house_owner_id = house_owner_id;
}

	public List<String> getId_type() {
		return id_type;
	}

	public void setId_type(List<String> id_type) {
		this.id_type = id_type;
	}

	public List<String> getId_number() {
		return id_number;
	}

	public void setId_number(List<String> id_number) {
		this.id_number = id_number;
	}

	public List<String> getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(List<String> issue_date) {
		this.issue_date = issue_date;
	}

	public List<String> getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(List<String> expiry_date) {
		this.expiry_date = expiry_date;
	}

	public List<String> getIssued_by() {
		return issued_by;
	}

	public void setIssued_by(List<String> issued_by) {
		this.issued_by = issued_by;
	}

	public List<String> getRecord_status() {
		return record_status;
	}

	public void setRecord_status(List<String> record_status) {
		this.record_status = record_status;
	}

	public List<String> getInputter() {
		return inputter;
	}

	public void setInputter(List<String> inputter) {
		this.inputter = inputter;
	}

	public List<String> getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(List<String> authorizer) {
		this.authorizer = authorizer;
	}

	public List<String> getDate_time() {
		return date_time;
	}

	public void setDate_time(List<String> date_time) {
		this.date_time = date_time;
	}


	public String getCurr_number() {
		return curr_number;
	}

	public void setCurr_number(String curr_number) {
		this.curr_number = curr_number;
	}

	public List<String> getOwner_identity_id() {
		return owner_identity_id;
	}

	public void setOwner_identity_id(List<String> owner_identity_id) {
		this.owner_identity_id = owner_identity_id;
	}

}
