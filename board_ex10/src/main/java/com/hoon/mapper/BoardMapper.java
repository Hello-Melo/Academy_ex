package com.hoon.mapper;

import java.util.List;

import com.hoon.model.Board;
import com.hoon.model.Criteria;

public interface BoardMapper {

	List<Board> getList(Criteria criteria);
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
	int totalCount(Criteria criteria);
	
}
