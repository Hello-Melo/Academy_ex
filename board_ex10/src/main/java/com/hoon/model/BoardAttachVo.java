package com.hoon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardAttachVo {
	
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private Long bno;
	

}
