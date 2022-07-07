<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container">
		<h2>로그아웃 페이지</h2>
			<form action="${contextPath }/myLogout" method="post">
				<button class="btn btn-danger">로그아웃</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"> 
			</form>

</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>