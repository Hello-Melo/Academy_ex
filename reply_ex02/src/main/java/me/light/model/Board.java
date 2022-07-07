package me.light.model;

import java.time.LocalDateTime;
import java.util.List;

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
public class Board {
	private Long bno; 
	private String title;  
	private String contents;  
	private String writer;  
	private LocalDateTime regDate; 
	private LocalDateTime updateDate;
	
	private int replyCnt;
	
	
	//게시글(1) -> 댓글(N)
	private List<Reply> replyList;
}
