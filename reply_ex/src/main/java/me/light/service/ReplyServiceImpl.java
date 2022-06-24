package me.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.light.mapper.ReplyMapper;
import me.light.model.Criteria;
import me.light.model.ReplyVo;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	//autowired 대신 allargs 어노테이션 써줘도 똑같음!
	ReplyMapper mapper;

	@Override
	public ReplyVo get(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
	}

	@Override
	public int modify(ReplyVo replyVo) {
		return mapper.update(replyVo);
	}

	@Override
	public List<ReplyVo> getList(Criteria cri, Long bno) {
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public int register(ReplyVo vo) {
		return mapper.insert(vo);
	}
	

}
