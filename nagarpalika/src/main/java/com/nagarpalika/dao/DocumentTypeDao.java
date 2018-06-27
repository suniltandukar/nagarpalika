package com.nagarpalika.dao;

import java.util.List;

import com.nagarpalika.model.DocumentTypeDetailModel;

public interface DocumentTypeDao {
	
	public void save(DocumentTypeDetailModel d);

	public List<DocumentTypeDetailModel> getDocumentType();

	public DocumentTypeDetailModel getSpecificDocumentType(String id);

	public void update(DocumentTypeDetailModel d, String id);

	public void delete(String id);

}
