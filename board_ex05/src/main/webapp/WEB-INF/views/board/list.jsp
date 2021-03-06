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

  <ul class="pagination">
<c:if test="${pageMaker.perv}">
<li class="page-item"><a href="?page=${pageMaker.startPage-1}" class="page-link">[이전]</a></li>
</c:if>

<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
		<li class="page-item ${param.page == pageNum ? 'active' : ' '  }"><a href="?page=${pageNum }" class="page-link">[${pageNum}]</a></li>
</c:forEach>

<c:if test="${pageMaker.next}">
<li class="page-item"><a href="?page=${pageMaker.endPage+1}" class="page-link">[다음]</a></li>
</c:if>
</ul>
<br>


<a href="${contextPath }/board/register" class="btn btn-secondary">글쓰기</a>

</div>
  

  
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>