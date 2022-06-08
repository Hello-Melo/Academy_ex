package board.me.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/welcome"}, method = RequestMethod.GET )
	// value는 /로 요청하면 /WEB-INF/views/welcome.jsp로 연결된다는것!
	public String home(HttpServletRequest request) {
		String name = request.getParameter("username");
		System.out.println(name);
		return "welcome"; // 뷰의 이름 
	}

	@RequestMapping(value="/member/join", method = RequestMethod.GET)
	public String memberJoin() {
		return "memberJoin";
	}
	
	@RequestMapping("/member/login")
	public String loginPage(@RequestParam("id") String userId,
		 String pw) {
		System.out.println(userId);
		System.out.println(pw);
		return "login";
	}

	@GetMapping("/member/list")
	public String memberList() {
		return "member_list";
	}
	
	
	
}


