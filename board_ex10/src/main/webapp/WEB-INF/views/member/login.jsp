<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>
  
<div class="container"> 
  	<div class="loginForm my-5">
	  <h2>로그인 페이지</h2>
	  		<div class="error">
	  			<p>${error }</p>
	  		</div>
  			<form action="${contextPath }/member/login" method="post"> <!--  액션과 메서드는 스프링 시큐리티의 고정값 -->
					<div class="form-group">
					  	<input type="text" name="loginId" placeholder="아이디" class="form-control" value="${loginId}">
					</div>
					<div class="form-group">
					  	<input type="password" name="loginPw" placeholder="비밀번호" class="form-control" value="${loginPw}">
					</div>
					<div class="form-group">
						<input type="checkbox" name="remember-me" >
						<label>Remember me</label>
					</div>
					<div class="error_area">
						${errorMessage}
					</div>
					<div class="form-group">
					  	<button class="btn btn-primary form-control">로그인</button>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"> 
  			</form>
  	</div>
  </div>
  
  
   <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
   <style>
   	.loginForm {
   			width : 400px; margin:auto;
   	}
   
   
   </style>