package com.nagarpalika.service;

import java.util.List;


import com.nagarpalika.model.DocumentTypeDetailModel;

public interface DocumentTypeService {
	public void save(DocumentTypeDetailModel d);

	public List<DocumentTypeDetailModel> getDocumentType();

	public DocumentTypeDetailModel getSpecificDocumentType(String id);

	public void update(DocumentTypeDetailModel d, String id);

	public void delete(String id);

}
