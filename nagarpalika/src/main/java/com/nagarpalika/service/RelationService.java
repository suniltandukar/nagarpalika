package com.nagarpalika.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarpalika.model.RelationModel;

public interface RelationService {
	public int save(RelationModel d);
	public int update(RelationModel d, String id);
	public List<RelationModel> findAll();
	public RelationModel findById(String id);
	public int delete(String id);
}
