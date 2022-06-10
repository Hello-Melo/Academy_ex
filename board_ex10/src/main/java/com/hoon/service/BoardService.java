package com.hoon.service;

import java.util.List;

import com.hoon.model.Board;

public interface BoardService {

	List<Board> getList();
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
	void totalCount();
	
}
