package com.hoon.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class, SecurityConfig.class}; 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
				}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	// 필터 처리
    @Override
    protected Filter[] getServletFilters() {
    	CharacterEncodingFilter filter = new CharacterEncodingFilter();
    	filter.setEncoding("utf-8");
    	filter.setForceEncoding(true);
    	return new Filter[] {filter};
    }
    
    //ckeditor 파일업로드 오버라이딩 메서드
    @Override
    protected void customizeRegistration(Dynamic registration) {
    	MultipartConfigElement multipartConfigElement
    	= new MultipartConfigElement("c:\\upload", 20971520, 41943040, 20971520);
    	registration.setMultipartConfig(multipartConfigElement);
    }

}
