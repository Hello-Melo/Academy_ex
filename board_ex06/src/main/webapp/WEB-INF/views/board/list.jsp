<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

	<div class="jumbotron">
		<h3>게시판 페이징 처리</h3>
	</div>
	
	
	<div class="container">
				<table class="table">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
						<c:forEach items="${list}" var="b">
						 	<tr>
								<td>${b.bno}</td>
								<td>${b.title}</td>
								<td>${b.writer}</td>
								<td>${b.regDate}</td>
								<td>${b.updateDate}</td>
							</tr>
						</c:forEach>
				</table>
			
	<ul class="pagination" align="center">
		<c:if test="${pageMaker.perv}">
				<li class="page-item"><a href="?page=${pageMaker.startPage-1 }" class="page-link">[이전]</a></li>
		</c:if>

		
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
				<li class="page-item ${param.page == pageNum ? 'active' : ' ' }"><a href="?page=${pageNum}" class="page-link">[${pageNum }]</a></li>
		</c:forEach>
	
		<c:if test="${pageMaker.next}">
			<li class="page-item"><a href="?page=${pageMaker.endPage+1}" class="page-link">[다음]</a></li>
		</c:if>
	</ul>
	</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>