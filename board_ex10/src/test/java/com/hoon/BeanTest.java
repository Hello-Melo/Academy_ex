package com.hoon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;
import com.hoon.model.Board;


public class BeanTest {
	
	
	@Test
	public void beanTest() {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(RootConfig.class);
		Board bean = ctx.getBean("testBean", Board.class);
		System.out.println(bean.getContents());
	}

}
