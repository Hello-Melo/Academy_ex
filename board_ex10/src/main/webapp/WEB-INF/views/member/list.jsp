<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron">
	<h2>회원 목록 게시판</h2>
	<br>
</div>



<div class="container">
	<h2>게시판</h2>
	<table class="table">
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${list}" var="b" varStatus="status">
			<tr>
				<td>${b.id}</td>
				<td><a 	href="get?id=${b.id}">
						${b.userName }</a></td>
				<td>${b.email }</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="5">회원이 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</table>
</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>