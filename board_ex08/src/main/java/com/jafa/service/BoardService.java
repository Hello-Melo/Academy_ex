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
	BoardMapper mapper;
	
	public List<Board> getList(Criteria criteria){
		return mapper.getList(criteria);
	}
	
	public Board get(Long bno, Criteria criteria) {
		return mapper.findByBno(bno, criteria);
	}
	
	public void insert(Board board) {
		mapper.insert(board);
	}
	
	public void update(Board board) {
		mapper.update(board);
	}
	
	public void delete(Long bno) {
		mapper.delete(bno);
	}
	
	public int totalCount(Criteria criteria) {
		return mapper.totalCount(criteria);
	}
	
}
