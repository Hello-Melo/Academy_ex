package com.jafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jafa.mapper.BoardMapper;
import com.jafa.model.Board;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;
	
	public List<Board> getList(){
		return mapper.getList();
	}
	
	public Board get(Long bno) {
	 return mapper.findByBno(bno);
	} 
	
	public void remove(Long bno) {
		mapper.delete(bno);
	}
	
	public void update(Board board) {
		mapper.update(board);
	}
	
	public void insert(Board board) {
		mapper.insert(board);
	}
		
	
	
}
