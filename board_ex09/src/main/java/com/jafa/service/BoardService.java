package com.jafa.service;

import java.util.List;

import com.jafa.model.Board;
import com.jafa.model.Criteria;


public interface BoardService  {
	
	
	List<Board> getList(Criteria criteria);
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
	int totalCount(Criteria criteria);
	

}
