package com.nagarpalika.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nagarpalika.dao.UploadDao;
import com.nagarpalika.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	UploadDao uploadDao;

	@Override
	public void upload(String fileLocation, String saveFileName, MultipartFile file) {
		uploadDao.upload(fileLocation, saveFileName, file);
	}

}
