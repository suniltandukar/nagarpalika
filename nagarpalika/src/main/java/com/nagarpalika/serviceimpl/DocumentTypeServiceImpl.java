
package com.nagarpalika.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nagarpalika.dao.DocumentTypeDao;
import com.nagarpalika.model.DocumentTypeDetailModel;
import com.nagarpalika.service.DocumentTypeService;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
	
	@Autowired
	DocumentTypeDao documentTypeDao;

	@Override
	public void save(DocumentTypeDetailModel d) {
		documentTypeDao.save(d);
	}

	@Override
	public List<DocumentTypeDetailModel> getDocumentType() {
		return documentTypeDao.getDocumentType();
	}

	@Override
	public DocumentTypeDetailModel getSpecificDocumentType(String id) {
		return documentTypeDao.getSpecificDocumentType(id);
	}

	@Override
	public void update(DocumentTypeDetailModel d, String id) {
		documentTypeDao.update(d, id);
	}

	@Override
	public void delete(String id) {
		documentTypeDao.delete(id);

	}

}
