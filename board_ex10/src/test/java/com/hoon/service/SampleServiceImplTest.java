package com.hoon.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class SampleServiceImplTest {

	@Autowired
	SampleService service;
	
	@Test
	public void test() throws Exception{
		Integer doAdd = service.doAdd("10", "21");
		System.out.println(doAdd);
	}

}
