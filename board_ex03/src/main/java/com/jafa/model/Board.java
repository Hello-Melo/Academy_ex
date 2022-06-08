package com.jafa.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @NoArgsConstructor @ToString
@Setter@AllArgsConstructor
public class Board {

	private long bno;
	private String title;
	private String contents;
	private String writer;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	
}
