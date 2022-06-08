package com.jafa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.model.Board;
import com.jafa.model.Criteria;

public interface BoardMapper {

	List<Board> getList(Criteria criteria);
	int totalCount(Criteria criteria);
	
	Board findByBno(@Param("bno") Long bno, @Param("criteria") Criteria criteria);
	
}
