package me.light.mapper;

import java.util.List;

import me.light.model.Board;
import me.light.model.Reply;

public interface BoardMapper {
	List<Board> getList(); 
	Board get(Long bno);
	
	List<Reply> getReplyList(Long bno);
	
	
	
}
