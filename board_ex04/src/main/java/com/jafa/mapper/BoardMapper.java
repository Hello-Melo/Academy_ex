package com.jafa.mapper;

import java.util.List;

import com.jafa.model.Board;
import com.jafa.model.Criteria;

public interface BoardMapper {
	
	List<Board> getList(Criteria criteria);
	void insert(Board board);
	Board findByBno(Long Bno);
	void update(Board board);
	void delete(Long Bno);
	int totalCount();
}
