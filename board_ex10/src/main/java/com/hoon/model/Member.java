package com.hoon.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.hoon.common.FieldMatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldMatch( first ="confirmPassword", second="password", message="비밀번호가 일치 하지 않습니다.")

public class Member {
	
		private Long id;
	
	 
	 @Pattern(regexp =  "^[가-힣|a-zA-Z]{2,5}$", message="이름은 2~5글자 사이어야 합니다.")
	 	private String userName;
	 
	 @Email(message = "이메일 형식이 아닙니다.")
	 @NotEmpty(message = "이메일은 반드시 입력하셔야 합니다.")
	private String email;
	 @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,15}$", message = "비밀번호는 숫자, 문자, 특수문자를 포함한 8~15자리 이내여야합니다.")
	private String password;
	private String confirmPassword;
	
	
}
