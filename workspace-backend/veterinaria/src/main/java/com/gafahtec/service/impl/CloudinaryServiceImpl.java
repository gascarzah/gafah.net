package com.gafahtec.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gafahtec.service.CloudinaryService;
@Service
public class CloudinaryServiceImpl implements CloudinaryService {

	 Cloudinary cloudinary;

	    private Map<String, String> p = new HashMap<>();

	    public CloudinaryServiceImpl() {
	    	
	    	 cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", "xx",
					"api_key", "xx",
					"api_secret", "xxx"));  

	    }

	    public Map upload(File file) throws IOException  {
	    	  Map params = ObjectUtils.asMap(
					    "folder", "proyectos/veterinaria", 
					    "overwrite", true,					    
					    "resource_type", "image"         
					);
	    	
//	        File file = convert(multipartFile);
	        Map result = cloudinary.uploader().upload(file, params);
	        file.delete();
	        return result;
	    }

	    public Map delete(String id) throws IOException {
	        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
	        return result;
	    }

	    private File convert(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream fo = new FileOutputStream(file);
	        fo.write(multipartFile.getBytes());
	        fo.close();
	        return file;
	    }
}
