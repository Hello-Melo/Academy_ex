<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>

		<div class="jumbotron">
			<h2>웰컴 투 더 딩딩월드!</h2>
		</div>
		

		<form:form action="register" method="post" modelAttribute="member">
			<div>
				이름 : <form:input path="userName"/>
				<form:errors path="userName" />
			</div>
			<div>
				이메일 : <form:input path="email"/>
				<form:errors path="email" />
			</div>
			<div>
				비밀번호 : <form:input path="password" type="password" />
				<form:errors path="password" />
			</div>
			<div>
				비밀번호확인 : <form:input path="confirmPassword" type="password" />
				<form:errors path="confirmPassword" />
			</div>
		<button>회원가입</button>
		</form:form>		
		
		
		
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>