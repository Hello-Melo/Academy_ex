package board.me;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jafa.CommonController;

@Configuration
public class RootConfig {

	//spring의 기본 설정하는 페이지
	
	
	//스프링 빈 등록하는 방법(이걸 쓰면 컴포넌트 스캔을 적지 않아도 적용됨)
	@Bean
	public CommonController  commonController() {
		return new CommonController();
		
	}
	
}
