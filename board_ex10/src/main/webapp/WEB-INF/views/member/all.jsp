<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="container">
		<sec:authorize access="isAnonymous()">
				<a href="/customLogin">로그인</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.memberVo" var="member" />
		${member.userName }님 로그인 중 ....
			<form action="${contextPath }/myLogout" method="post">
					<button class="btn btn-danger">로그아웃</button>
					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token }">
			</form>
		</sec:authorize>
</div>



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>