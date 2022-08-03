<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/get.js"></script>
		<!--  아래 코드는 로그인이 되었을시에 sername을 불러와 userId에 저장한는 의미
		이 부분이 없으면 겟을 부를때 에러가 남-->
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="userId"/>
	</sec:authorize>

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
			<!--  cjrf 이름을 붙여서 토큰임을 명시. 이를 각 POST를 담당하는 폼 태그에 넣으면
			삭제, 둥록, 수정등이 정상작동-->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"> 
		
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
		<p>
		조회수 : ${board.viewCount}
		</p>
		<div>
			내용 : <br> ${board.contents}
		</div>

		페이지 : ${pageMaker.criteria.page}<br> 타입 :
		${pageMaker.criteria.type}<br> 키어드 :
		${pageMaker.criteria.keyword}<br>
		<c:if test="${userId eq board.writer}">
				<button class="btn btn-warning remove">삭줴</button>
				<button class="btn btn-danger update">수쟝</button>
		</c:if>
		<button class="btn btn-primary list">목록</button>
	</form>

	<!-- 댓글 -->

	<div class="row mt-5">
		<div class="col-lg-12">
			<div class="card card-default">
				<div class="card-heading">
					<h4 class="test">댓글을 달아주세여</h4>
				</div>

				<div class="card-body">
					<ul class="chat">
						<!--  start reply-->
						
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


<!-- 댓글 등록  -->
			<!-- 마찬가지로 로긴이 되어있을때만 댓글 등록 버튼이 나게 하는 코드-->
		<sec:authorize access="isAuthenticated()">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#replyForm" id="addReplyBtn">
				  댓글 등록
			</button>
		</sec:authorize>
		<!--  이건 로그인 안할경우 댓글 등록이 안나타내고 이게 나타남-->
		<sec:authorize access="Anonymous">
			댓글을 등록 하시려면 로그인 하세요
		</sec:authorize>
	<div>
		댓글 수 : ${board.replyCnt }
	</div>



<!-- 댓글 -->
<div class="modal fade" id="replyForm" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="replyForm">댓글 달기</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="reply">내용 입력</label>
					<input class="form-control" name="reply" id= "reply"> 
				</div>
				<div class="form-group">
					<label for="replyer">작성자</label>
					<input class="form-control" name="replyer" id="replyer"> 
				</div>
				<div class="form-group">
					<label for="regDate">등록일</label>
					<input class="form-control" name="regDate" id="regDate" value="${board.regDate}">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="modalRemoveBtn">삭제</button>
				<button type="button" class="btn btn-danger" id="modalMoBtn">수정</button>
				<button type="button" class="btn btn-primary" id="modalRegisterBtn">등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalCloseBtn" >닫기</button>
			</div>
		</div>
	</div>
</div>

	<div class="row my-5">
  			<div class="col-lg-12">
  				<div class="card">
  					<div class="card-header">
  						<h4>파일 첨부 내용</h4>	
  					</div>
  					<div class="card-body">
  						<div class="uploadResult">
  							<ul class="list-group">
  							</ul>
  						</div>
  					</div> <!-- panel body -->
  				</div> <!-- panel end-->
  			</div><!-- col end -->
  		</div><!-- row end -->


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
			getForm.append($('#bno'));
			getForm.append($('#writer'));
			getForm.attr('method', 'post');
			getForm.attr("action","delete" );
			getForm.submit();
	})
	
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
		


</script>