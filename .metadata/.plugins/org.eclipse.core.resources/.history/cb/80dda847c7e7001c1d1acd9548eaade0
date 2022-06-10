package com.jafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jafa.mapper.BoardMapper;
import com.jafa.model.Board;
import com.jafa.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
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
	public int totalCount(Criteria criteria) {
		return mapper.totalCount(criteria);
	}
	

}
