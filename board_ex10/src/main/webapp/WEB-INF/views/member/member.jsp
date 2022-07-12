<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>



	<div class="container">
	
		<sec:authentication property="principal.memberVo.userId" var="userId"/>
		<h2>회원 페이지</h2>
		
		<a href="${contextPath }/myLogout">로그아웃하러 가자</a>
		<a href="${contextPath }/anno/myPage/${userId}">마이 페이지</a>
	</div>

	

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>