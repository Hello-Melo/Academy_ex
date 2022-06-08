package com.jafa.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.config.AppTest;
import com.jafa.model.Board;

public class DataInsert extends AppTest{
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void insertData() {
		
		for(int i = 1; i <= 412; i++) {
		
		Board board = new Board();
		board.setTitle("제목인걸~ "+  i );
		board.setContents("내용인걸~ "+  i);
		board.setWriter("이름인걸~ "+ i);
		mapper.insert(board);
		}
		
	}
}
