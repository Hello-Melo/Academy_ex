package com.hoon;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class Test11 {
	
	
	@Test
	@Ignore
	public void test00() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String formDate = sdf.format(date);
		
		System.out.println(formDate);
		
		String test = formDate.replace("-", File.separator);
		System.out.println(test);
	}
	
	
	@Test
	public void test01() {
		String contentType = "image...";
		System.out.println(contentType.startsWith("image"));
	}
	

}
