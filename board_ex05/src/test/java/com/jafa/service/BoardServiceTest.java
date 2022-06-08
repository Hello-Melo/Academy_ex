package com.jafa.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.AppTest;
import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;
import com.jafa.mapper.BoardMapper;
import com.jafa.model.Board;
import com.jafa.model.Criteria;


public class BoardServiceTest extends AppTest {

	@Autowired
	BoardMapper mapper;
	
	@Autowired
	Criteria criteria;
	
	@Test
	public void getListTest() {
		List<Board> list = mapper.getList(criteria);
		assertEquals(4, list.size());
		
	}

}
