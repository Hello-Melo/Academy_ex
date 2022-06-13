package com.hoon.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;
import com.hoon.mapper.BoardMapper;
import com.hoon.model.Board;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration

public class PagingTest {

	@Autowired
	BoardMapper mapper;
	
	
	@Test
	public void insertData() {
		
		for(int i = 1; i <= 412; i++) {
		
		Board board = new Board();
		board.setTitle("제목 : Spring 연습중입니다유" + i);
		board.setContents("내용 : 테스트에트으~ 테스트중입니다유" + i);
		board.setWriter("침펄풍" + i);
		mapper.insert(board);
		
		
		}
	}

}
