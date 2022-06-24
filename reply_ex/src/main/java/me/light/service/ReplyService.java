package me.light.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.light.model.Criteria;
import me.light.model.ReplyVo;

public interface ReplyService {

	ReplyVo get(Long bno);
	void remove(Long bno);
	int modify(ReplyVo replyVo);
	List<ReplyVo> getList(Criteria cri, Long bno);
	int register(ReplyVo vo);
	
	
	
}
