package com.jafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jafa.mapper.BoardMapper;
import com.jafa.model.Board;
import com.jafa.model.Criteria;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<Board> getList(Criteria criteria){
		return boardMapper.getList(criteria);
	}
	
	public void insert(Board board) {
		 boardMapper.insert(board);
	}
	
	public int totalCount() {
		return boardMapper.totalCount();
	}
}
