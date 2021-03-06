<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    
    <div class="jumbotron">
    	<h2>게시판 페이징</h2>
    </div>
    
    <div class="searchArea">
    	<form action="${contextPath}/board/list" id="searchForm">
				<select name="type">
						<option value="">====</option>
						<option value="T" ${pageMaker.criteria.type eq 'T' ? 'selected' : ' ' }>제목</option>
						<option value="C" ${pageMaker.criteria.type eq 'C' ? 'selected' : ' ' }>내용</option>
						<option value="W" ${pageMaker.criteria.type eq 'W' ? 'selected' : ' ' }>작성자</option>
				</select>
				<input type="text" name="keyword" value="${pageMaker.criteria.keyword}">
				<button class="btn btn-info">검색</button>
    	</form>
    </div>
    
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
								<a href="get?bno=${b.bno}&page=${pageMaker.criteria.page}&type=${pageMaker.criteria.type}&keyword=${pageMaker.criteria.keyword}">${b.title }</a></td>
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
		
		<a href="${contextPath }/board/register" class="btn btn-secondary">글쓰기</a><br>
		
		
		<form action="${contextPath}/board/list" id="pageForm">
				<input type="hidden" value="${pageMaker.criteria.page}" name="page">
				<input type="hidden" value="${pageMaker.criteria.type}" name="type">
				<input type="hidden" value="${pageMaker.criteria.keyword}" name="keyword">
			<ul class="pagination justify-content-center">
				<c:if test="${pageMaker.perv}">
						<li class="page-item"><a href="${pageMaker.startPage-1}" class="page-link">이전</a></li>
				 </c:if>
				
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="pageNum"> 
					<li class="page-item ${pageMaker.criteria.page == pageNum ? 'active' : ' ' }"><a href="${pageNum}" class="page-link">${pageNum}</a></li>
				</c:forEach>
				
				<c:if test="${pageMaker.next}">
						<li class="page-item"><a href="${pageMaker.endPage+1}" class="page-link">다음</a></li>
				 </c:if>
			</ul>
		</form>
		</div>
    
    <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    
    <script>
    $(function() {
    	
    	let pageForm = $('#pageForm');
    	$('#pageForm a').on('click', function (e) {
    		e.preventDefault();
    		pageForm.find('input[name="page"]').val($(this).attr('href'));
    		
    		$('#pageForm').submit();
		})
	})
        </script>