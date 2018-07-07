package com.nagarpalika.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarpalika.model.RelationModel;

public interface RelationService {
	public List<RelationModel> findAll();

}
