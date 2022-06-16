package com.hoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoon.mapper.BoardMapper;
import com.hoon.model.Board;
import com.hoon.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<Board> getList(Criteria criteria) {
		return mapper.getList(criteria);
	}

	@Override
	public Board findByBno(Long bno) {
		return mapper.findByBno(bno);
	}

	@Override
	public void insert(Board board) {
		mapper.insert(board);
	}

	@Override
	public void update(Board board) {
		mapper.update(board);
	}

	@Override
	public void delete(Long bno) {
		mapper.delete(bno);
	}


	@Override
	public int totalCoutnt(Criteria criteria) {
		return mapper.totalCount(criteria);
	}

	
}
