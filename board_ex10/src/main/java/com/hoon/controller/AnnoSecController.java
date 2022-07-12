package com.hoon.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hoon.exception.NotMatchUserIdException;
import com.hoon.model.MemberVo;
import com.hoon.security.MyUser;

@Controller
public class AnnoSecController {
	
	//회원페이지(member 혹은 admin 롤이 있을때
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@GetMapping("/anno/member")
	public String memberPage() {
		return "member/member";
	}
	
	
	//마이페이지
//	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
//	@GetMapping("/anno/myPage")
//	public String myPage(@AuthenticationPrincipal MemberVo vo) {
//		System.out.println(vo.getUserId());
//		return "myPage";
//	}
	
	//@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/anno/myPage/{userId}")
	public String myPage(@PathVariable String userId,
			@AuthenticationPrincipal MyUser myUser, Model model) {
		//pathvariable 어노테이션은 해당 파라미터를 경로로 사용 할 수 있게 해준다.
		
		MemberVo vo = myUser.getMemberVo();
		if(!vo.getUserId().equals(userId)) {
			//예외 발생
			throw new NotMatchUserIdException();
		}
		model.addAttribute("member", vo);
		return "member/myPage";
	}
	
	
}
