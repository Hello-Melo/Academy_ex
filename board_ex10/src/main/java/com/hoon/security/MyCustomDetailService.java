package com.hoon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hoon.mapper.MemberMapper;
import com.hoon.model.MemberVo;

@Component
public class MyCustomDetailService implements UserDetailsService {

	@Autowired
	MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo memberVo = mapper.read(username);
		if(memberVo == null) {
			throw new UsernameNotFoundException(username);
			
		}
		return memberVo != null? new MyUser(memberVo) : null ;
	}

}
