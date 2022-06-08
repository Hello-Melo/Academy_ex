package com.jafa.mapper;

import java.util.List;

import com.jafa.model.Board;
import com.jafa.model.Criteria;

public interface BoardMapper {

	List<Board> getList(Criteria criteria);
	int totalCount();
	void insert(Board board);
	
	Board get(Long bno);
	void update(Board board);
	void delete(Long bno);
	
}
