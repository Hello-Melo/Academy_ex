package security_ex.com.hoon;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import security_ex.com.hoon.model.Demo;

public class RootConfigTest {

	@Test
	public void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		System.out.println(context);
		
		Demo demo1 = context.getBean("demo1", Demo.class);
		Demo demo2 = context.getBean("demo2", Demo.class);
		
		System.out.println(demo1.getKill());
		System.out.println(demo2.getKill());
	}
	
	@Test
	public void test2() {
		String path = "classpath:security/security-context.xml";
			ApplicationContext ctx = new ClassPathXmlApplicationContext(path) ;
			System.out.println(ctx);
			Demo demo1 = ctx.getBean("demo1", Demo.class);
			Demo demo2 = ctx.getBean("demo2", Demo.class);
			
			System.out.println(demo1.getKill());
			System.out.println(demo2.getKill());
			
			
	}
	
	@Test
	public void test3() {
		// file: 이거는 src이전 즉 이 프로젝트의 시작 지점을 의미
		String path = "file:src/main/webapp/WEB-INF/spring/demo-context.xml";
			ApplicationContext ctx = new ClassPathXmlApplicationContext(path) ;
			System.out.println(ctx);
			Demo demo3 = ctx.getBean("demo3", Demo.class);
			
			System.out.println(demo3.getKill());
			
	}

}
