package security_ex.com.hoon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import security_ex.com.hoon.RootConfig;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
