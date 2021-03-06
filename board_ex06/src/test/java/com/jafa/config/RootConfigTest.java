package com.jafa.config;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.mapper.testMapper;

public class RootConfigTest extends AppTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	testMapper mapper;
	
	@Test
	public void dataSourceTest() {
		assertNotNull(dataSource);
	}

	@Test
	public void sqlTest() {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void mapperTest() {
		System.out.println(mapper.mytime());
	}
	
}
