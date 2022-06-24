package me.light.mapper;

import static org.junit.Assert.*;

import java.util.List; 
import java.util.function.Consumer;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.light.config.RootConfig;
import me.light.config.ServletConfig;
import me.light.model.Criteria;
import me.light.model.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class ReplyMapperTest {

	@Autowired
	ReplyMapper mapper;
	
	
	@Test
	public void getListTest() {
		System.out.println(mapper.getListAll());
		//List<ReplyVo> list = mapper.getListAll();
		// 람다식으로 변경해서 쓰는것(foreach는 반복문)
		mapper.getListAll().forEach(vo -> System.out.println(vo));
		// 리턴값 없음
//		list.forEach(vo -> {
//			System.out.println(vo);
//		});

		;
	}
	
	@Test
	@Ignore
	public void insertTest() {
		ReplyVo vo = new ReplyVo();
		vo.setBno(1L);
		vo.setReply("I wana go to my home");
		vo.setReplyer("태ㅔ스터훈");
		mapper.insert(vo);
		
	}

	@Test
	@Ignore
	public void deleteTest() {
		mapper.delete(15L);
		}
	
	@Test
	@Ignore
	public void updateTest() {
		ReplyVo vo = new ReplyVo();
		vo.setRno(17L);
		vo.setReply("I am your father");
		vo.setReplyer("Darth Vader");
		mapper.update(vo);
		
	}
	
	
	@Test
	@Ignore
	public void listTest() {
		mapper.getListWithPaging(new Criteria(), 1L)
		.forEach(vo -> System.out.println(vo));
		
	}
	
	
}
