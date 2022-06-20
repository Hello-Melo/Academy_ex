package com.hoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

public interface ReplyMapper {

	List<ReplyVo> getListAll();
	
	
	List<ReplyVo> getListWithPaging(@Param("cri") Criteria criteria, @Param("bno") Long bno);

	
	int insert(ReplyVo vo);
	
	ReplyVo read(Long rno);
	
	int delete(Long rno);

	int update(ReplyVo vo);
	
	
}
