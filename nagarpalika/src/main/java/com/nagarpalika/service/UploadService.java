package com.nagarpalika.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	public void upload( String fileLocation, String saveFileName, MultipartFile file);
}
