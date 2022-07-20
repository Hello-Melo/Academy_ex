package com.hoon.mapper;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;
import com.hoon.model.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class BoardMapperTest {

	@Autowired
	BoardMapper mapper;
	
	@Test
	//@Ignore
	public void insertTest() {
		Board vo = new Board();
		for(int i = 1 ; i <402 ; i++) {
		vo.setTitle("제목테스트" + i + "입니다"+ i);
		vo.setContents("내용테스트 입니다" + i);
		vo.setWriter("글쓴이 " + i + " 지롱" + i);
		mapper.insert(vo);
		}
	}
}
