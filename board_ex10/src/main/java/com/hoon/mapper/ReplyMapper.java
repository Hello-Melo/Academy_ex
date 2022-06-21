package com.hoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

public interface ReplyMapper {

	// 실제 쓰지 않는 데이터 연결 확인용
	List<ReplyVo> getListAll();
	
	// 댓글 페이지 불러오기
	List<ReplyVo> getListWithPaging(@Param("cri") Criteria criteria, @Param("bno") Long bno);

	// 데이터 삽입
	int insert(ReplyVo vo);
	// 데이터 읽기
	ReplyVo read(Long rno);
	// 데이터 삭제
	int delete(Long rno);
	// 데이터 수정
	int update(ReplyVo vo);
	
	
}
