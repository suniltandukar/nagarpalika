package com.nagarpalika.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HouseFacilityDetailModel {
	
	@Id
	private int house_owner_id_hibernate;
	
	private String house_owner_id,
	land_house_id,
	drinking_water_type,
	drinking_water_sufficiency,
	drainage_manegement,
	electricity_facility,
	street_light_facility,
	telephone_facility,
	internet_facility,
	tv_facility,
	road_type,
	road_width,
	record_status,
	company_id,
	branch_id,
	inputter,
	authorizer,
	date_time,
	curr_number;

	public String getHouse_owner_id() {
		return house_owner_id;
	}

	public void setHouse_owener_id(String house_owner_id) {
		this.house_owner_id = house_owner_id;
	}

	public String getLand_house_id() {
		return land_house_id;
	}

	public void setLand_house_id(String land_house_id) {
		this.land_house_id = land_house_id;
	}

	public String getDrinking_water_type() {
		return drinking_water_type;
	}

	public void setDrinking_water_type(String drinking_water_type) {
		this.drinking_water_type = drinking_water_type;
	}

	public String getDrinking_water_sufficiency() {
		return drinking_water_sufficiency;
	}

	public void setDrinking_water_sufficiency(String drinking_water_sufficiency) {
		this.drinking_water_sufficiency = drinking_water_sufficiency;
	}

	public String getDrainage_manegement() {
		return drainage_manegement;
	}

	public void setDrainage_manegement(String drainage_manegement) {
		this.drainage_manegement = drainage_manegement;
	}

	public String getElectricity_facility() {
		return electricity_facility;
	}

	public void setElectricity_facility(String electricity_facility) {
		this.electricity_facility = electricity_facility;
	}

	public String getStreet_light_facility() {
		return street_light_facility;
	}

	public void setStreet_light_facility(String street_light_facility) {
		this.street_light_facility = street_light_facility;
	}

	public String getTelephone_facility() {
		return telephone_facility;
	}

	public void setTelephone_facility(String telephone_facility) {
		this.telephone_facility = telephone_facility;
	}

	public String getInternet_facility() {
		return internet_facility;
	}

	public void setInternet_facility(String internet_facility) {
		this.internet_facility = internet_facility;
	}

	public String getTv_facility() {
		return tv_facility;
	}

	public void setTv_facility(String tv_facility) {
		this.tv_facility = tv_facility;
	}

	public String getRoad_type() {
		return road_type;
	}

	public void setRoad_type(String road_type) {
		this.road_type = road_type;
	}

	public String getRoad_width() {
		return road_width;
	}

	public void setRoad_width(String road_width) {
		this.road_width = road_width;
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
	
	

}