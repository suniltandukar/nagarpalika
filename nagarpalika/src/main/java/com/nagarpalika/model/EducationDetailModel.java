package com.nagarpalika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EducationDetailModel {
private String edu_id,
education_type,
record_status,
inputter,
authorizer,
date_time, curr_number;

public String getEdu_id() {
	return edu_id;
}

public void setEdu_id(String edu_id) {
	this.edu_id = edu_id;
}

public String getEducation_type() {
	return education_type;
}

public void setEducation_type(String education_type) {
	this.education_type = education_type;
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

public String getCurr_number() {
	return curr_number;
}

public void setCurr_number(String curr_number) {
	this.curr_number = curr_number;
}



}
