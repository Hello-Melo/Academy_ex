package com.hoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoon.model.Board;
import com.hoon.model.Criteria;

public interface BoardMapper {

	List<Board> getList(Criteria criteria);
	Board findByBno(Long bno);
	void insert(Board board);
	void update(Board board, boolean b);
	void delete(Long bno);
	int totalCount(Criteria criteria);
	void updateReplyCnt(
			@Param("bno") Long bno,
			@Param("amount") int amount
			);
	
	void addViewCount(Long bno);
	
}
