package security_ex.com.hoon;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value= {
		"classpath:security/security-context.xml"
		
})
public class RootConfig {

	
	
}
