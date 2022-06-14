package com.hoon.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
public class Member {
	
	 @Size(min=2, max=5)
	 	private String userName;
	 @Email
	private String email;
	private String password;
	private String confirmPassword;
	
	
}
