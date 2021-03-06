package com.jafa.config;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.test.AppTest;

public class RootConfigTest extends AppTest{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	
	@Test
	public void dataSourcetest() {
		assertNotNull(dataSource);
	}

	@Test
	public void sqlTest() {
		assertNotNull(factory);
	}
	
}
