package com.hoon.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoon.mapper.BoardAttachMapper;
import com.hoon.model.BoardAttachVo;


@Component
public class FileCheckTask {
	
	@Autowired
	private BoardAttachMapper attachMapper;
	

	@Scheduled(cron="0 0 2 * * * ")
	public void checkFiles() {
		System.out.println("되남?");
		
		List<BoardAttachVo> fileList = attachMapper.getOldFiles();
		
		System.out.println(fileList);
		
		List<Path> fileListPaths = fileList.stream().map(vo -> Paths.get(
				"c:/upload/",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
				.collect(Collectors.toList());
		
		fileList.stream().filter(vo -> vo.isFileType()==true).map(vo-> Paths.get(
				"c:/upload/"+vo.getUploadPath(), "s_"+vo.getUuid()+"_"+vo.getFileName()))
		.forEach(p -> fileListPaths.add(p));
		
		System.out.println(fileListPaths);
		
		File targetDir = Paths.get("c:/upload/", getFolderYesterDay()).toFile();
		File[] removeFiles = targetDir.listFiles(file-> fileListPaths.contains(file.toPath())==false);
		
		System.out.println(Arrays.toString(removeFiles));
		Arrays.asList(removeFiles).forEach(f->f.delete());
		
	}


	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal =  Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return sdf.format(cal.getTime()).replace("-", File.separator);
	}
	
	
	
}
