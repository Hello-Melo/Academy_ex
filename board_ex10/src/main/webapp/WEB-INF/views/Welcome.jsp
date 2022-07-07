<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>

		<div class="jumbotron">
			<h2>웰컴 투 더 딩딩월드!</h2>
		</div>

<spring:message code="board.bno" /> <br>
<spring:message code="board.title" /> <br>
<spring:message code="board.contents" /> <br>
<spring:message code="board.writer" /> <br>

  <div class="container">
		<h3>HOME</h3>
		<p><a href="${contextPath}/security/all"> 모든 방문자 허용</a></p>
		<p><a href="${contextPath}/security/member"> 회원등급 이상</a></p>
		<p><a href="${contextPath}/security/admin"> 관리자</a></p>
  </div>


Welcome to the dingding World

  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>