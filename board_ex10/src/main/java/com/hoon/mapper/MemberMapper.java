package com.hoon.mapper;

import java.util.List;

import com.hoon.model.Member;

public interface MemberMapper {

	List<Member> findAll();
	Member findById(Long id);
	void insert(Member member);
	void delete(Long id);
	void update(Member member);
	int totalCount();
	
	Member findByEmail(String email);
}
