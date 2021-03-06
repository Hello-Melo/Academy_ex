<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    
  <div class = "container">

	<h2>게시판</h2>
		<table class="table">
				<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>수정일</th>
				</tr>
		<c:forEach items="${list }" var= "b">
				<tr>
						<td>${b.bno }</td>
						<td>
						<a href="get?bno=${b.bno}">${b.title }</a></td>
						<td>${b.writer }</td>
						<td>
						<fmt:parseDate var="regDate" value="${b.regDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						<fmt:formatDate value="${regDate }" pattern="yyyy-MM-dd HH:mm" />
						</td>
						<td>
						<fmt:parseDate var="updateDate" value="${b.updateDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						<fmt:formatDate value="${updateDate }" pattern="yyyy-MM-dd HH:mm" />
						</td>
				</tr>
		</c:forEach>
		</table>
		
		<c:if test="${pageMaker.perv }">
		<a href="?page=${pageMaker.startPage-1}">[이전]</a>
		</c:if>


		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
				<a href="?page=${pageNum }">[${pageNum}]</a>
		</c:forEach>

		<c:if test="${pageMaker.next }">
		<a href="?page=${pageMaker.endPage+1}">[다음]</a>
		</c:if>

<a href="${contextPath }/board/register" class="btn btn-secondary">글쓰기</a>

</div>

    
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>