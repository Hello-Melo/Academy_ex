package com.jafa.mapper;

import java.util.List;

import com.jafa.model.Board;

public interface BoardMapper {

	List<Board> getList();
	void insert(Board board);
	Board findByBno(Long bno);
	void update(Board board);
	void delete(Long bno);
	
	
}
