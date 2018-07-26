package com.nagarpalika.dao;

import org.springframework.web.multipart.MultipartFile;

public interface UploadDao {
	public void upload( String fileLocation, String saveFileName, MultipartFile file);

}
