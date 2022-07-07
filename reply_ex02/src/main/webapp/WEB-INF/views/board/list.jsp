<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jspf" %>
<div class="container">
<table class="table">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${list}" var="b">
	<tr>
		<td>${b.bno }</td>
		<td>
			<a href="get?bno=${b.bno }">${b.title}</a>
		</td>
		<td>${b.regDate }</td>
	</tr>
	</c:forEach>
</table>
</div>
<%@ include file="../layout/footer.jspf" %>