package com.hoon.config;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class RootConfigTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() {
		assertNotNull(dataSource);
	}

}
