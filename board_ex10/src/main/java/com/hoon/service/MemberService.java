package com.hoon.service;

import java.util.List;

import com.hoon.model.Criteria;
import com.hoon.model.Member;

public interface MemberService {

	List<Member> findAll(Criteria criteria);
	Member findById(Long id);
	void insert(Member member);
	void delete(Long id);
	void update(Member member);
	int totalCount(Criteria criteria);
	
}
