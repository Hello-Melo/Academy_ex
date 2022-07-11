package com.hoon.security;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.PrepareTestInstanceEvent;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoon.config.RootConfig;
import com.hoon.config.ServletConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class MemberTest2 {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Test
	@Ignore
	public void memberInsertTest() {
		String sql = "insert into member_tbl(userId, userPw, userName) values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "okeunghoon");
			pstmt.setString(2,  encoder.encode("1234"));
			pstmt.setString(3, "옥승훈");
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
		@Test
			public void adminInsertTest2() {
			String sql = "insert into member_tbl(userId, userPw, userName) values(?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, "admin");
				pstmt.setString(2,  encoder.encode("1234"));
				pstmt.setString(3, "관리자");
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
