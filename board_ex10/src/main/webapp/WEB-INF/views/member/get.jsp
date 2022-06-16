<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class=container>
	<h2>헬로 멜로</h2>
	<div class="getData">
		<input type="hidden" name="page" id="page" value="${param.page}">
		<input type="hidden" name="type" id="type" value="${param.type}">
		<input type="hidden" name="keyword" id="keyword" value="${param.keyword}">
	</div>

	<form id="getForm">

	<p>회원번호 : ${member.id }</p>
	<p>회원이름 : ${member.userName }</p>
	<p>회원이메일 : ${member.email }</p>
	<div>
		내용 : <br>
		페이지 : ${param.page}<br>
		타입 : ${param.type}<br>
		키어드 : ${param.keyword}<br>
	</div>
		
			<button class="btn btn-warning delete">삭줴</button>
				<button class="btn btn-danger update">수쟝</button>
				<button class="btn btn-primary list">목록</button>
	</form>

</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

<script>
$(function () {
	let getForm = $('#getForm');
	
	$('#getForm .list').on('click', function () {
		getForm.empty();
		getForm.append($('#page'));
		getForm.append($('#type'));
		getForm.append($('#keyword'));
		getForm.attr("action", "list");
		getForm.submit();
	})
	
	$('#getForm .update').on('click', function () {
		getForm.attr("action", "update");
		getForm.submit();
	})
	
	$('#getForm .delete').con('click', function(){
		getForm.attr('method', 'post');
		getForm.attr("action", "delete")
		getForm.submit();
	})
	
})

</script>