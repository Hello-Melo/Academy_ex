<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<div class="container">
		<h2>관리자 페이지</h2>
		
		<div>
			MemberVo : <sec:authentication property="principal.memberVo" var="member"/><br>
			아이디 : <sec:authentication property="principal.memberVo.userId"/><br>
			이름 : <sec:authentication property="principal.memberVo.userName"/><br>
			권한 : <sec:authentication property="principal.memberVo.authList"/><br>
		</div>
		
		<a href="${contextPath }/myLogout">로그아웃하러 가자</a>
	</div>

	<div>
		되냐<br>
		${member }
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>