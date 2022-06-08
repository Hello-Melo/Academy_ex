package board.me;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = {"board.me"})
public class ServletConfig implements WebMvcConfigurer {
	

@Override
public void configureViewResolvers(ViewResolverRegistry registry) {
	InternalResourceViewResolver viewResolver = 
		new InternalResourceViewResolver();
	
	// 이건 irvr이 경로를 설정해주는 역할을 하는 것.
	
	
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");
	registry.viewResolver(viewResolver);
	//WEB-INF/views/**.jsp 
}

}