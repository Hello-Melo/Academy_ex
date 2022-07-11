package com.hoon.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.hoon.model.MemberVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyUser extends User{
	
	private MemberVo memberVo;
	
	private static final long serialVersionUID = 8115135934494880457L;

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public MyUser(MemberVo memberVo) {
		super(memberVo.getUserId(), memberVo.getUserPw(),
				memberVo.getAuthList().stream().map(vo -> new SimpleGrantedAuthority(vo.getAuth()))
				.collect(Collectors.toList())
				);
		this.memberVo = memberVo;
		//autoVO -> SimplegreatedAutrity로 변환
	}

	

}
