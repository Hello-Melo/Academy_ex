package com.hoon.mapper;

import java.util.List;

import com.hoon.model.Criteria;
import com.hoon.model.Member;
import com.hoon.model.MemberVo;

public interface MemberMapper {

	List<Member> findAll(Criteria criteria);
	Member findById(Long id);
	void insert(Member member);
	void delete(Long id);
	void update(Member member);
	int totalCount(Criteria criteria);
	
	Member findByEmail(String email);
	
	MemberVo read(String userId);
	
}
