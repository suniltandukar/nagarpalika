package com.nagarpalika.model;

public class HouseRentDetailModel {
	private String house_rent_id,
	land_house_id,
	rented_storied,
	rented_room,
	rented_from,
	rented_purpose,
	record_status,
	company_id,
	branch_id,
	inputter,
	authorizer,
	date_time;
	private String curr_number;
	
	private String company_name,register_number,registered_date,license_providing_office,telephone_number,type_of_business,manager_owner;
	
	private HouseOwnerDetailModel houseOwnerDetailModel;

	public HouseOwnerDetailModel getHouseOwnerDetailModel() {
		return houseOwnerDetailModel;
	}

	public void setHouseOwnerDetailModel(HouseOwnerDetailModel houseOwnerDetailModel) {
		this.houseOwnerDetailModel = houseOwnerDetailModel;
	}

	public String getLand_house_id() {
		return land_house_id;
	}

	public void setLand_house_id(String land_house_id) {
		this.land_house_id = land_house_id;
	}

	public String getRented_storied() {
		return rented_storied;
	}

	public void setRented_storied(String rented_storied) {
		this.rented_storied = rented_storied;
	}

	public String getRented_room() {
		return rented_room;
	}

	public void setRented_room(String rented_room) {
		this.rented_room = rented_room;
	}

	public String getRented_from() {
		return rented_from;
	}

	public void setRented_from(String rented_from) {
		this.rented_from = rented_from;
	}

	public String getRented_purpose() {
		return rented_purpose;
	}

	public void setRented_purpose(String rented_purpose) {
		this.rented_purpose = rented_purpose;
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

	public String getHouse_rent_id() {
		return house_rent_id;
	}

	public void setHouse_rent_id(String house_rent_id) {
		this.house_rent_id = house_rent_id;
	}
	
	


}
