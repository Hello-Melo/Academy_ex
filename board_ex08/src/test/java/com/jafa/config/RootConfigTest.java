package com.jafa.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class RootConfigTest extends TestApp{

	@Test
	public void dataSourceTest() {
		assertNotNull(dataSource);
		
	}

}
