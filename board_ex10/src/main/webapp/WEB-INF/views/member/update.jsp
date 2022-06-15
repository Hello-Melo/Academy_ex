<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container">
<h2>글 내용 수정</h2>

<form action="${contextPath}/member/update" method="post">
<input type="hidden" name="id"  value="${param.id }">
회원이름 : <input type="text" name="userName" value="${param.userName }">
회원이메일 : <input type="text" name="email" value="${param.email }">
회원비밀번호 : <input type="text" name="password" value="${param.password }">

<button>
회원정보 수정
</button>
</form>

</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>