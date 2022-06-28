package com.hoon.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

@Controller
public class uploadController {

	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile file : uploadFile) {
			System.out.println("==========");
			System.out.println("파일 이름 : " + file.getOriginalFilename());
			System.out.println("파일 크기 : " + file.getSize());
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
	
 @PostMapping("/uploadAjaxAction")
 @ResponseBody
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
	 	File uploadPath = new File("c:\\upload", getFolder());
	 		if(!uploadPath.exists()) {
	 			uploadPath.mkdirs();
	 		}
	 
	 
		for(MultipartFile file : uploadFile) {
			System.out.println("==========");
			System.out.println("파일 이름 : " + file.getOriginalFilename());
			System.out.println("파일 크기 : " + file.getSize());
			
			File saveFile = new File(uploadPath, file.getOriginalFilename());
				try {
					file.transferTo(saveFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
 }

private String getFolder() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String str =sdf.format(new Date());
	return str.replace("-", File.separator);
}
	
}
