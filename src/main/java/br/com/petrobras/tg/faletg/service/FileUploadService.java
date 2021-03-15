package br.com.petrobras.tg.faletg.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private final String pasta = "anexos";

	public String save(Integer id, MultipartFile file) throws IOException {
		Path pastaPath = Paths.get(pasta);
		if(Files.notExists(pastaPath)) {
			Files.createDirectory(pastaPath);
		}		
		Path idPath = Paths.get(pasta + File.separator + Integer.toString(id));
		if(Files.notExists(idPath)) {
			Files.createDirectory(idPath);
		}		
		Path uploadPath = Paths.get(idPath + File.separator + StringUtils.cleanPath(file.getOriginalFilename())); 
		InputStream is = file.getInputStream();
		Files.copy(is, uploadPath, StandardCopyOption.REPLACE_EXISTING);
		return uploadPath.toString();
	}
}
