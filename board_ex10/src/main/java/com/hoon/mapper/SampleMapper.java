package com.hoon.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper {

	@Insert("insert into tb_sp1 values (#{data})")
	int insertCol(String data);
	
	
}
