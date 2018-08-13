package com.nagarpalika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DisableTypeModel {
	private int id;
	private String disable_type;
	private String typehead;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypehead() {
		return typehead;
	}
	public void setTypehead(String typehead) {
		this.typehead = typehead;
	}
	public String getDisable_type() {
		return disable_type;
	}
	public void setDisable_type(String disable_type) {
		this.disable_type = disable_type;
	}
	
	
	

}
