package com.hoon.controller;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.HashMap;
	import java.util.Scanner;

	public class UItest3dto {

	   public static void main(String[] args) throws Exception {
	      
	       int code     = input();
	       HashMap<String, Object> hm = service(code);
	       output(   hm );
	    }

	   public static int input() {
	      Scanner sc = new Scanner(System.in);
	      
	         System.out.print("조회할 코드 => ");
	         int code = sc.nextInt();
	      
	      sc.close();
	      return code;
	   }

	   public static  HashMap<String, Object> service(int code) throws Exception   {
	       Customer dto = dao(code);
	       HashMap<String, Object> hm = new HashMap<String, Object>();

	               
	      if (dto != null)
	         { 
	            hm.put("MSG", "요청하신 코드가 정상 조회되었습니다." );
	         }else {
	           hm.put("MSG", "요청하신 코드는 자료가 없습니다." );
	         }
	      
	      hm.put("DTO", dto);      
	      return hm;
	   }
	   
	   public static  Customer dao(int code) throws Exception   {
	       String sql; 
	       PreparedStatement pstmt;     
	       ResultSet rs;
	       HashMap<String, Object> hm = new HashMap<String, Object>();
	       String driver   = "oracle.jdbc.driver.OracleDriver";
	       String url      = "jdbc:oracle:thin:@localhost:1521:XE"; //localhost:port/db명
	       String user     = "dev";
	       String password = "123456";
	             
	       
	       Class.forName(driver);
	       Connection con = DriverManager.getConnection(url, user, password);

	       Customer  dto = null;
	       sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
	       pstmt = con.prepareStatement(sql);
	       pstmt.setInt(1, code);  
	       
	       rs = pstmt.executeQuery();
	               
	      if (rs.next())
	         {
	        dto = new Customer(); 
	         dto.setCode   (rs.getInt      ("CODE"));
	         dto.setName   (rs.getString   ("NAME"));
	         dto.setEmail   (rs.getString   ("EMAIL"));
	         dto.setTel      (rs.getString   ("TEL"));
	         dto.setWeight   (rs.getDouble   ("WEIGHT"));

	      hm.put("DTO", dto);      
	      rs.close();
	      pstmt.close();
	      con.close();
	   }
	   return dto;   
	   }  
	   public static void output(HashMap<String, Object> hm) {
	       Customer dto = (Customer)hm.get("DTO");
	      
	      if (dto != null) 
	      {
	          System.out.println("code   = " + dto.getCode());
	          System.out.println("name   = " + dto.getName());
	          System.out.println("email  = " + dto.getEmail());
	          System.out.println("tel    = " + dto.getTel());
	          System.out.println("weight = " + dto.getWeight());
	          System.out.println(dto);
	      }
	      System.out.println("MSG = " + (String)hm.get("MSG"));
	   }
	}
}
