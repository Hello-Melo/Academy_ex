package com.hoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoon.mapper.ReplyMapper;
import com.hoon.model.Criteria;
import com.hoon.model.ReplyVo;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	

	@Override
	public List<ReplyVo> getList(Criteria criteria, Long bno) {
		return mapper.getListWithPaging(criteria, bno);
				
	}

	@Override
	public int register(ReplyVo vo) {
		return mapper.insert(vo);
	}

	@Override
	public ReplyVo get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVo vo) {
		return mapper.update(vo);
	}

}
