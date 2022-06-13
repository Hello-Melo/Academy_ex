<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>

		<div class="jumbotron">
			<h2>글쓰기게쉬푸ㅏㄴ!</h2>
		</div>

	<form:form action="${contextPath }/board/register" path="register" modelAttribute="board" >
			제목 : <form:input type= "text" path ="title" /><br>
				<form:errors path="title" class="error" element="div" /><br>
			내용 : <form:textarea rows="30" cols="50" path="contents"  /><br>
			작성자 : <form:input type= "text" path ="writer"  />
			<form:errors path="writer" element="div" />
			<br>
			<button>등록</button>
	</form:form>
  
  <style>
  .error{font-size:20px; color:red;}  
  </style>

  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
