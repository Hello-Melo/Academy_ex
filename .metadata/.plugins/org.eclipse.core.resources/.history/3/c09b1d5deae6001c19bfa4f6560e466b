<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container">
<h2>글 내용 수정</h2>

<form action="${pageContext.request.contextPath}/board/update" method="post">
<input type="hidden" name="bno"  value="${param.bno }">
제목 : <input type="text" name="title" value="${param.title }">
작성자 : <input type="text" name="writer" value="${param.writer }">
내용 : <textarea rows="" cols="" name ="contents"></textarea>

<button>
글 수정
</button>
</form>

</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>