<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<div class=container>
<h2>헬로 멜로</h2>

<p>제목 : ${board.title }</p>
<p>작성자  : ${board.writer }</p>
<p>작성일 : 
					<fmt:parseDate var="regDate" value="${board.regDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" />
					<fmt:formatDate value="${regDate }" pattern="yyyy-MM-dd HH:mm" />
</p>
<p>수정일 : 
					<fmt:parseDate var="updateDate" value="${board.updateDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" />
					<fmt:formatDate value="${updateDate }" pattern="yyyy-MM-dd HH:mm" />
</p>
<div>
내용 : <br>
${board.contents }
</div>

<form action="${contextPath }/board/delete" method="post">
<input type="hidden" name="bno" value="${board.bno }">
<button>삭줴</button>
</form>

<form action="${contextPath }/board/modify" >
<input type="hidden" name="bno" value="${board.bno }">
<input type="hidden" name="title" value="${board.title }">
<input type="hidden" name="writer" value="${board.writer }">
<input type="hidden" name="contents" value="${board.contents }">
<button>수쟝</button>
</form>

</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>