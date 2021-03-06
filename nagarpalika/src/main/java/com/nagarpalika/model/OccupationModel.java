package com.nagarpalika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OccupationModel {
	private String occu_id,
	occupation_type,
	record_status,
	inputter,
	authorizer,
	date_time,
occupation_id;
	private String curr_number;
	public String getOccu_id() {
		return occu_id;
	}

	public void setOccu_id(String occu_id) {
		this.occu_id = occu_id;
	}

	public String getOccupation_type() {
		return occupation_type;
	}

	public void setOccupation_type(String occupation_type) {
		this.occupation_type = occupation_type;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
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

	public String getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(String occupation_id) {
		this.occupation_id = occupation_id;
	}

	public String getCurr_number() {
		return curr_number;
	}

	public void setCurr_number(String curr_number) {
		this.curr_number = curr_number;
	}


}
