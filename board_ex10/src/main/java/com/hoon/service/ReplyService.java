package com.hoon.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

public interface ReplyService {

	List<ReplyVo> getList(Criteria criteria, Long bno);
	
	int register(ReplyVo vo);
	
	ReplyVo get(Long rno);
	
	int remove(Long rno);

	int modify(ReplyVo vo);
	
}
