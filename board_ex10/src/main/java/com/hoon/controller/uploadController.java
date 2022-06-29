package com.hoon.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.hoon.model.AttachFileDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class uploadController {

	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile file : uploadFile) {
			
			
			
			File saveFile = new File("c:\\upload", file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
	
	}
	
 @PostMapping(value= "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
 @ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
	 	List<AttachFileDTO> list = new ArrayList<AttachFileDTO>(); //리스트 생성
	 
	 	File uploadPath = new File("c:\\upload", getFolder());
	 		if(!uploadPath.exists()) {
	 			uploadPath.mkdirs();
	 		}
	 
		for(MultipartFile file : uploadFile) {
			AttachFileDTO attachFileDTO = new AttachFileDTO();
			String uploadFilename = file.getOriginalFilename();
			attachFileDTO.setFileName(uploadFilename); // uuid 생성전
			
			UUID uuid = UUID.randomUUID();
			uploadFilename = uuid.toString() + "_" + uploadFilename;

			File saveFile = new File(uploadPath, uploadFilename);
				try {
					file.transferTo(saveFile);
					attachFileDTO.setUuid(uuid.toString());
					attachFileDTO.setUploadPath(getFolder());
					if (checkImageFile(saveFile)) {
						attachFileDTO.setImage(true);
						FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFilename));
						Thumbnailator.createThumbnail(file.getInputStream() , thumbnail, 100, 100);
					}
					list.add(attachFileDTO);
				} catch (Exception e) {
					e.printStackTrace();
				} 
		}
		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
 }

private String getFolder() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String str =sdf.format(new Date());
	return str.replace("-", File.separator);
}
	

private boolean checkImageFile(File file) {
	try {
		String contentType = Files.probeContentType(file.toPath());
		return contentType.startsWith("image");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}
}
