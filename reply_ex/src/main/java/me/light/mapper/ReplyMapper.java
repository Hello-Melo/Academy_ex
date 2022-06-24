package me.light.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.light.model.Criteria;
import me.light.model.ReplyVo;

public interface ReplyMapper {

	List<ReplyVo> getListAll();
	ReplyVo get(Long bno);
	int insert(ReplyVo vo);
	int delete(Long bno);
	int update(ReplyVo replyVo);
	List<ReplyVo> getListWithPaging(
			@Param("cri") Criteria cri, 
			@Param("bno") Long bno
			);
	
	
}
