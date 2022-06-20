package com.hoon.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;
import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class ReplyMapperTest {

	@Autowired
	ReplyMapper mapper;
	
	@Test
	@Ignore
	public void getListTest() {
		List<ReplyVo> list = mapper.getListAll();
		System.out.println(list);
		assertNotNull(list);
		assertEquals(2, list.size());
	}
	
	@Test
	@Ignore
	public void insertTest() {
		ReplyVo vo = new ReplyVo();
		vo.setBno(1L);
		vo.setReply("댓글자겁중......");
		vo.setReplyer("악플러");
		int result = mapper.insert(vo);
		System.out.println("머가 찍혔누" + result);
	}

	@Test
	@Ignore
	public void findRno() {
		ReplyVo vo = new ReplyVo();
		System.out.println(mapper.read(4L));
	}
	
	@Test
	@Ignore
	public void deleteRno() {
		mapper.delete(2L);
	}
	
	@Test
	@Ignore
	public void updateTest() {
		ReplyVo vo = new ReplyVo();
		vo.setRno(4L);
		vo.setReply("댓글 작업 수정 중임돠.,..,.,.,.");
		mapper.update(vo);
		System.out.println(vo);
		
	}

	@Test
	public void getListWithPagingSTest() {
		List<ReplyVo> getListWithPaging = mapper.getListWithPaging(new Criteria(), 1L);
		System.out.println(getListWithPaging);
	}
	
}
