package com.hoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoon.mapper.MemberMapper;
import com.hoon.model.Criteria;
import com.hoon.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public List<Member> findAll(Criteria criteria) {
		return mapper.findAll(criteria);
	}

	@Override
	public Member findById(Long id) {
		return mapper.findById(id);
	}

	@Override
	public void insert(Member member) {
		mapper.insert(member);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public void update(Member member) {
		mapper.update(member);
	}

	@Override
	public int totalCount(Criteria criteria) {
		return mapper.totalCount(criteria);
	}


}
