<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="jumbotron">
		<div class="getData">
			<input type="hidden" name="page" id="page" value="${param.page}">
			<input type="hidden" name="type" id="type" value="${param.type}">
			<input type="hidden" name="keyword" id="keyword" value="${param.keyword}">
			<input type="hidden" name="bno" id="bno" value="${board.bno}">
			<input type="hidden" name="title" id="title" value="${board.title}">
			<input type="hidden" name="writer" id="writer" value="${board.writer}">
		</div>


	<h2>상세정보</h2>
</div>

		<div class=container>
		<form id="getForm">
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

				
				<button class="btn btn-warning remove">삭줴</button>
				<button class="btn btn-danger update">수쟝</button>
				<button class="btn btn-primary list">목록</button>
		</form>
	
		</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

<script>
$(function () {
	
	let getForm = $('#getForm')
	$('#getForm .list').on('click', function () {
		getForm.empty();
		getForm.append($('#page'));
		getForm.append($('#type'));
		getForm.append($('#keyword'));
		getForm.attr("action","list" );
		getForm.submit();
	})
	
		$('#getForm .update').on('click', function () {
			getForm.append($('#bno'));
			getForm.append($('#title'));
			getForm.append($('#writer'));
			getForm.attr("action","update" );
			getForm.submit();
	})
	
		$('#getForm .remove').on('click', function () {
		getForm.attr('method', 'post');
		getForm.attr("action","remove" );
		getForm.submit();
	})

})
/* 	$(function(){
			
		let bnoValue = $('input[name="bno"]').val();
		let reply = {
				bno : bnoValue,
				reply : "ajax 등록 및 테스트",
				replyer : "테스타"
								
		};
		let callback = function (result) {
			alert("결과 : " + result);
		}
	replyService.add(reply, callback);
				
	}); */
	

</script>