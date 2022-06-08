package com.jafa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//컨트롤러로 등록이 되면, 스프링 빈(bean)이 된다. = 컴포넌트
@Controller
public class CommonController {
	
	@GetMapping("/common/page1")
	public void common() {
		
	}
	
	// 요청 : /common/page1
	//view 이름 : /common/page1
	// /WEB-INF/views/common/page1.jsp

}
