package com.hoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoon.mapper.BoardMapper;
import com.hoon.mapper.ReplyMapper;
import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final static int Reply_ADD = 1;
	private final static int Reply_DEL = -1;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<ReplyVo> getList(Criteria criteria, Long bno) {
		return mapper.getListWithPaging(criteria, bno);
				
	}

	@Transactional
	@Override
	public int register(ReplyVo vo) {
		boardMapper.updateReplyCnt(vo.getBno(), Reply_ADD);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVo get(Long rno) {
		return mapper.read(rno);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		boardMapper.updateReplyCnt(mapper.read(rno).getBno(), Reply_DEL);
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVo vo) {
		return mapper.update(vo);
	}

}
