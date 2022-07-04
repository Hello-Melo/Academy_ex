package com.hoon.service;

import java.util.List;

import com.hoon.model.Board;
import com.hoon.model.BoardAttachVo;
import com.hoon.model.Criteria;

public interface BoardService {

	List<Board> getList(Criteria criteria);
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
	
	int totalCoutnt(Criteria criteria);
	List<BoardAttachVo> getAttachList(Long bno);
}
