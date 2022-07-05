package com.hoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoon.mapper.BoardAttachMapper;
import com.hoon.mapper.BoardMapper;
import com.hoon.model.Board;
import com.hoon.model.BoardAttachVo;
import com.hoon.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<Board> getList(Criteria criteria) {
		return mapper.getList(criteria);
	}

	@Override
	public Board findByBno(Long bno) {
		return mapper.findByBno(bno);
	}

	@Transactional
	@Override
	public void insert(Board board) {
		mapper.insert(board);
		if(board.getAttachList() == null || board.getAttachList().size()==0) return;
		board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
	}

	@Transactional
	@Override
	public void update(Board board) {
		attachMapper.deleteAll(board.getBno());
		mapper.update(board);
		if(board.getAttachList() != null) {
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
		}
	}

	@Transactional
	@Override
	public void delete(Long bno) {
		attachMapper.deleteAll(bno);
		mapper.delete(bno);
	}


	@Override
	public int totalCoutnt(Criteria criteria) {
		return mapper.totalCount(criteria);
	}

	@Override
	public List<BoardAttachVo> getAttachList(Long bno) {
		return attachMapper.findByBno(bno);
	}

	
}
