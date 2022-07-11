package com.hoon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.hoon.service.ReplyService;
import com.hoon.service.ReplyServiceImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@MapperScan("com.hoon.mapper")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
/* xml 땡겨올때는 임포트리소스로 땡기기
 * @ImportResource(value= { "classpath:config/security-config.xml"
 * 
 * })
 * 
 * 자바 설정을 땡겨 올때는 임포트 어노테이션을 사용한다!
 */
/* @Import(value= {SecurityConfig.class}) */
public class RootConfig   {
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(); 
		resolver.setMaxUploadSize(5248800);
		resolver.setMaxInMemorySize(10485760);
		return resolver; 
	}
	
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source
		 = new  ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/message", "classpath:/message/errors");
		// message/message.properties
		// message/message_ko.properties 로 찾아감(한글이면)
		source.setDefaultEncoding("utf-8");
		return source;
		
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost/board");
		config.setUsername("root");
		config.setPassword("1234");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		return bean.getObject();
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
