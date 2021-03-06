<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="jumbotron">
	<h2>상세정보</h2>
</div>


<div class=container>
<h2>헬로 멜로</h2>


<p>제목 : ${board.title }</p>
<p>작성자  : ${board.writer }</p>
<p>작성일 : 
				<fmt:parseDate  var="regDate"  value="${board.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"    />
				<fmt:formatDate value="${ regDate}" pattern="yyyy-MM-dd HH:mm"/>
</p>
<p>수정일 : 
				<fmt:parseDate  var="updateDate"  value="${board.updateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"    />
				<fmt:formatDate value="${ updateDate}" pattern="yyyy-MM-dd HH:mm"/>
</p>
<div>
내용 : <br>
${board.contents }
</div>

			페이지 : ${pageMaker.criteria.page}<br>
				타입 : ${pageMaker.criteria.type}<br>
				키어드 : ${pageMaker.criteria.keyword}<br>

			<form action="${contextPath }/board/remove" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<button class="btn btn-warnning">삭줴</button>
			</form>

			<form action="${contextPath }/board/update" >
					<input type="hidden" name="bno" value="${board.bno }">
					<input type="hidden" name="title" value="${board.title }">
					<input type="hidden" name="writer" value="${board.writer }">
					<input type="hidden" name="contents" value="${board.contents }">
					<button class="btn btn-danger">수쟝</button>
			</form>
		<form action="${contextPath }/board/list">
					<input type="hidden" name="page" value="${pageMaker.criteria.page}">
					<input type="hidden" name="type" value="${pageMaker.criteria.type}">
					<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}">
				<button class="btn btn-primary">목록</button>
		</form>
	
		</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>