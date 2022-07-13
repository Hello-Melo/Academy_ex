package com.hoon.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoon.model.Board;
import com.hoon.model.BoardAttachVo;
import com.hoon.model.Criteria;

public interface BoardService {

	List<Board> getList(Criteria criteria);
	Board findByBno(Long bno, boolean isAddCount);
	void insert(Board board);
	void update(Board board, boolean b);
	void delete(Long bno);
	
	int totalCoutnt(Criteria criteria);
	
	
	List<BoardAttachVo> getAttachList(Long bno);
}
