package com.jafa.mapper;

import java.util.List;

import com.jafa.model.Board;
import com.jafa.model.Criteria;

public interface BoardMapper {

	List<Board> getList(Criteria criteria);
	Board findById(Long bno);
	void update(Board board);
	void delete(Long bno);
	void insert(Board board);
	int totalCount();
}
