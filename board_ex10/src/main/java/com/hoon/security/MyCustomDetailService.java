package com.hoon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hoon.mapper.MemberMapper;
import com.hoon.model.MemberVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyCustomDetailService implements UserDetailsService {

	@Autowired
	MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo memberVo = mapper.read(username);
		
		return memberVo != null? new MyUser(memberVo) : null ;
	}

}
