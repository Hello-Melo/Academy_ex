<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/layout/header.jsp" %>
	
	<div class="jumbotron">
			<h2>지유 게시판</h2>
			<div class="listData">
				<input type="hidden" name="bno" id ="bno" value="">
				<input type="hidden" value="${pageMaker.criteria.page}" name="page" id="page">
				<input type="hidden" value="${pageMaker.criteria.type}" name="type" id="type">
				<input type="hidden" value="${pageMaker.criteria.keyword}" name="keyword" id="keyword">
			</div>	
	</div>
	
	<form action="${contextPath}/board/list" id = "listForm">
		<div>
			<select name="type">
				<option value="">====</option>			
				<option value="T" ${pageMaker.criteria.type eq 'T' ? 'selected' : ' '}>제목</option>
				<option value="C" ${pageMaker.criteria.type eq 'C' ? 'selected' : ' '}>내용</option>
				<option value="W" ${pageMaker.criteria.type eq 'W' ? 'selected' : ' '}>작성자</option>
			</select>		
			<input type="text" name="keyword" value="${pageMaker.criteria.keyword}">
			<button class="btn btn-info">검색</button>
		</div>
	</form>
	
	
	
<%-- 	<div class="searchArea">
		<form action="${contextPath}/board/list" id="searchForm">
			<select name="type">
				<option value="">====</option>
				<option value="T" ${pageMaker.criteria.type eq 'T' ? 'selected' : ' ' }>제목</option>
				<option value="C" ${pageMaker.criteria.type eq 'C' ? 'selected' : ' ' }>내용</option>
				<option value="W" ${pageMaker.criteria.type eq 'W' ? 'selected' : ' ' }>글쓴이</option>
			</select>
				<input type="text" name="keyword" value="${pageMaker.criteria.keyword }"> 
				<button class="btn btn-info">검색</button>
		</form>
	</div> --%>

	
	<div class="container">
		<table class="table">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>등록일</th>
					<th>수정일</th>
				</tr>
			<c:forEach items="${list}" var="b">
				<tr>
					<td>${b.bno}</td>
					<td> <a class="get" href="${b.bno}">
							${b.title}
							</a>
					</td>
					<td>${b.writer}</td>
					<td>
						<fmt:parseDate var="regDate" value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						<fmt:formatDate value="${regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<fmt:parseDate var="updateDate" value="${b.updateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						<fmt:formatDate value="${updateDate}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div class="pagination">
			<ul class="pagination justify-content-center">
				<c:if test="${pageMaker.perv}">
					<li class="page-item"><a href="${pageMaker.startPage-1}" class="page-link">이전</a></li>
				</c:if>
				
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
				 	<li class="page-item ${pageMaker.criteria.page == pageNum ? 'active' : '' }"><a href="${pageNum}" class="page-link"> [${pageNum}]</a></li>
				</c:forEach>
			
				<c:if test="${pageMaker.next}">
					<li class="page-item"><a href="${pageMaker.endPage+1}" class="page-link">다음</a></li>
				</c:if>
		    </ul>
		  </div>
    
 <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
 
 <script>
 	$(function () {
 		
 		let listForm = $('#listForm');
 		$('.pagination a').on('click', function (e) {
 			e.preventDefault();
 			$('.listData').find('#page').val($(this).attr('href'));
 			
 			if(listForm.find('input[name="keyword"]').val()==''){
 				listForm.find('input[name="keyword"]').remove();
 				listForm.find('select[name="type"]').remove();
 			}
 		
 			listForm.append($('#page'));
			listForm.submit();
 			
		});

 		$('.get').on('click', function (e) {
 			e.preventDefault();
			let bno = $(this).attr('href');
			$('#bno').val(bno);
			listForm.append($('#bno'));
			listForm.append($('#page'));
 			listForm.attr("action", "get?bno="+bno)
 			listForm.submit();
			
		})
 		
 		
	})
 
 
 </script>