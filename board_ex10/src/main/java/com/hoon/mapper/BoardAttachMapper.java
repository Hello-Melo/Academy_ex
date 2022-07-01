package com.hoon.mapper;

import java.util.List;

import com.hoon.model.BoardAttachVo;

public interface BoardAttachMapper {

		void insert(BoardAttachVo vo);
		void delete(String uuid);
		List<BoardAttachVo> findByBno(Long bno);
		
}
