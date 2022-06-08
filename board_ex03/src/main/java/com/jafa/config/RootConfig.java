package com.jafa.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jafa.controller.HomeContorller;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
@MapperScan("com.jafa")
public class RootConfig {
	
//	@Bean
//	public HomeContorller homeController() {
//		return new HomeContorller();
//	}

	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost/board_ex");
		config.setUsername("root");
		config.setPassword("1234");
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource;
	}
	
	//의존성 라이브러리 는 pom.xml에 log4jdbc와 logback 을 추가해주고
	// driverclassname과 url주소를 변경!
	//resources폴더 내에 log4jdbc.log4j2.properties 와 logback.xml을 만듬
	//이렇게하면 실행시 각각의 로그를 알 수있어 해석이 편리하다.
	
	
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory () throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	
}
