<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script src="${contextPath}/resources/js/get.js"></script>


<div class="jumbotron">
	<div class="getData">
		<input type="hidden" name="page" id="page" value="${param.page}">
		<input type="hidden" name="type" id="type" value="${param.type}">
		<input type="hidden" name="keyword" id="keyword"
			value="${param.keyword}"> <input type="hidden" name="bno"
			id="bno" value="${board.bno}"> <input type="hidden"
			name="title" id="title" value="${board.title}"> <input
			type="hidden" name="writer" id="writer" value="${board.writer}">
	</div>


	<h2>상세정보</h2>
</div>

<div class=container>
	<form id="getForm">
		<h2>헬로 멜로</h2>

		<p>제목 : ${board.title }</p>
		<p>작성자 : ${board.writer }</p>
		<p>
			작성일 :
			<fmt:parseDate var="regDate" value="${board.regDate}"
				pattern="yyyy-MM-dd'T'HH:mm:ss" />
			<fmt:formatDate value="${ regDate}" pattern="yyyy-MM-dd HH:mm" />
		</p>
		<p>
			수정일 :
			<fmt:parseDate var="updateDate" value="${board.updateDate}"
				pattern="yyyy-MM-dd'T'HH:mm:ss" />
			<fmt:formatDate value="${ updateDate}" pattern="yyyy-MM-dd HH:mm" />
		</p>
		<div>
			내용 : <br> ${board.contents }
		</div>

		페이지 : ${pageMaker.criteria.page}<br> 타입 :
		${pageMaker.criteria.type}<br> 키어드 :
		${pageMaker.criteria.keyword}<br>


		<button class="btn btn-warning remove">삭줴</button>
		<button class="btn btn-danger update">수쟝</button>
		<button class="btn btn-primary list">목록</button>
	</form>

	<!-- 댓글 -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"> 댓글창입니다 </i>
				</div>

				<div class="panel-body">
					<ul class="chat">
						<!--  start reply-->
						<li class="left clearfix" data-rno='3'>
							<div>
								<div class="header">
									<strong class="primary-font">작승자</strong> <small
										class="pull-right text-muted">2022-06-22</small>
								</div>
								<p>댓글 내융....</p>
							</div>
						</li>
					</ul>
				</div>
				<!--  /panel-body-->
			</div>
			<!--  /panel-->
		</div>
		<!--  /col-lg12 -->
	</div>
	<!--  /row-->

</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

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

		
	
	$(function () {
	let bnoValue = $('input[name="bno"]').val();
	
	replyService.getList({bno:bnoValue, page:1}, function(list) {
			for(let reply of list){
				console.log(list);
			}
	})
	});


/*
 * 댓글 입력 테스트 $(function(){
 * 
 * let bnoValue = $('input[name="bno"]').val(); let reply = { bno : bnoValue,
 * reply : "ajax 등록 및 테스트", replyer : "테스타"
 *  }; let callback = function (result) { alert("결과 : " + result); }
 * replyService.add(reply, callback);
 * 
 * });
 */
	
	
$(function () {
	// 수정테스트
	function updateTest(){
		replyService.update({
			rno : 5,
			bno : 1,
			reply : "댓글 수정 테스트트트트"
		}), function (result) {
			alert("결과 : " + result);
		}
	}
	
	function deleteTest() {
		replyService.remove(7, function(result) {
		 alert(result);	
		}), function () {
			alert('실패')
		}
	}
})
		
})

</script>