package com.hoon.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVo {

	
	private String userId;
	private String userPw;
	private String userName;
	
	private boolean enabled;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	private List<AuthVO> authList;
}
