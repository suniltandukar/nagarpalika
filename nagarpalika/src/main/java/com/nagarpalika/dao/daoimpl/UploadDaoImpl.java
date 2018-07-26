package com.nagarpalika.dao.daoimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nagarpalika.dao.UploadDao;

@Repository
public class UploadDaoImpl implements UploadDao{
	
	public void upload( String fileLocation, String saveFileName, MultipartFile file){
		File uploadDir = new File(fileLocation);
		//create folder if not exists
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(fileLocation, saveFileName)));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
