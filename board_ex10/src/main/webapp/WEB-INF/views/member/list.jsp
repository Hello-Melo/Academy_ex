<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<div class="jumbotron">
			<h2>회원 목록 게시판</h2>
			<br>
			<div class="listData">
				<input type="hidden" name="id" id="id" value="">
				<input	type="hidden" value="${pageMaker.criteria.page}" name="page" id="page">
				<input type="hidden" value="${pageMaker.criteria.type}" name="type" id="type">
				<input type="hidden" value="${pageMaker.criteria.keyword}" name="keyword"	id="keyword">
			</div>
		</div>
		
		<form action="${contextPath}/member/list" id="listForm">
			<div>
				<select name="type">
					<option value="">====</option>
					<option value="I"
						${pageMaker.criteria.type  eq 'I' ? 'selected' : ' ' }>회원번호</option>
					<option value="N"
						${pageMaker.criteria.type  eq 'N' ? 'selected' : ' ' }>회원이름</option>
					<option value="E"
						${pageMaker.criteria.type  eq 'E' ? 'selected' : ' ' }>이메일</option>
				</select> <input type="text" name="keyword"
					value="${pageMaker.criteria.keyword}">
				<button class="btn btn-info">검색</button>
			</div>
		</form>
		
		
		
		
		<%-- <div class="searchArea justify-content-center">
			<form action="${contextPath}/member/list" id="searchForm">
				<select name="type">
					<option value="">====</option>
					<option value="I"
						${pageMaker.criteria.type  eq 'I' ? 'selected' : ' ' }>회원번호</option>
					<option value="N"
						${pageMaker.criteria.type  eq 'N' ? 'selected' : ' ' }>회원이름</option>
					<option value="E"
						${pageMaker.criteria.type  eq 'E' ? 'selected' : ' ' }>이메일</option>
				</select> <input type="text" name="keyword"
					value="${pageMaker.criteria.keyword}">
				<button class="btn btn-secondary">검색</button>
			</form>
		</div> --%>
		
		<div class="container">
			<h2>게시판</h2>
			<table class="table">
				<tr>
					<th>회원번호</th>
					<th>회원이름</th>
					<th>이메일</th>
				</tr>
				<c:forEach items="${list}" var="b" varStatus="status">
					<tr>
						<td>${b.id}</td>
						<td><a href="${b.id}" class="get"> ${b.userName }</a></td>
						<td>${b.email }</td>
					</tr>
				</c:forEach>
				<c:if test="${empty list}">
					<tr>
						<td colspan="5">회원이 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</table>
		
			<div class="pagination">
				<ul class="pagination justify-content-center">
					<c:if test="${pageMaker.perv}">
						<li class="page-item"><a href="${pageMaker.startPage-1 }"
							class="page-link">이전</a></li>
					</c:if>
		
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
						var="pageNum">
						<li class="page-item"><a href="${pageNum}" class="page-link">${pageNum}</a></li>
					</c:forEach>
		
					<c:if test="${pageMaker.next}">
						<li class="page-item"><a href="${pageMaker.endPage+1 }"
							class="page-link">다음</a></li>
					</c:if>
				</ul>
			</div>
			
		</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

<script>
	$(function() {

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
		})

		$('.get').on('click', function (e) {
			e.preventDefault();
			let id = $(this).attr('href');
			$('#id').val(id);
			listForm.append($('#id'));
			listForm.append($('#page'));
			listForm.attr("action", "get?id="+id);
			listForm.submit();
		})
		
	})
</script>