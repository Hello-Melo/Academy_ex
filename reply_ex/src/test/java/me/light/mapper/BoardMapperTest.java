package me.light.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.light.config.RootConfig;
import me.light.config.ServletConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class BoardMapperTest {

	@Autowired
	BoardMapper mapper; 
	
	@Test
	public void getListTest() {
		System.out.println(mapper.getList());
		System.out.println(mapper.get(1L));
		;
	}

}
