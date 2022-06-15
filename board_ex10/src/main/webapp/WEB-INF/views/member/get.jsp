<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<div class=container>
<h2>헬로 멜로</h2>

<p>회원번호 : ${member.id }</p>
<p>회원이름  : ${member.userName }</p>
<p>회원이메일  : ${member.email }</p>
<div>
내용 : <br>

</div>


<form action="${contextPath }/member/remove" method="post">
<input type="hidden" name="id" value="${member.id}">
<button>삭줴</button>
</form>

			<form action="${contextPath }/member/update" >
					<input type="hidden" name="id" value="${member.id }">
					<input type="hidden" name="userName" value="${member.userName}">
					<input type="hidden" name="email" value="${member.email }">
					<input type="hidden" name="password" value="${member.password }">
					<button>수쟝</button>
			</form>
		<form action="${contextPath }/member/list">
				<button>목록</button>
		</form>
		
	
		</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>