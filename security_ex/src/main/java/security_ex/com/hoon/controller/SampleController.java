package security_ex.com.hoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		
	}
	
	@GetMapping("/member")
	public void doMember() {
		
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		
	}

}
