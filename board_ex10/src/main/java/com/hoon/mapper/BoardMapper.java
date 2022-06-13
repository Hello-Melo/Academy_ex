package com.hoon.mapper;

import java.util.List;

import com.hoon.model.Board;

public interface BoardMapper {

	List<Board> getList();
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
	void totalCount();
	
}
