package com.jafa.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Select;

public interface testMapper {

	@Select("select now()")
	Date mytime();
}
