<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>

		<div class="jumbotron">
			<h2>글쓰기게쉬푸ㅏㄴ!</h2>
		</div>

<div class="container">

		<form:form action="${contextPath }/board/register" path="register" modelAttribute="board" id="registerForm">
			<div class="form-group">
				제목 : <form:input type= "text" path ="title" /><br>
						<form:errors path="title" class="error" element="div" /><br>
						</div>
				
						<div class="form-group">	
				내용 : <form:textarea rows="20" cols="130" path="contents"  /><br>
						</div>
						<div class="form-group">
				작성자 : <form:input type= "text" path ="writer"  />
							<form:errors path="writer" element="div" /><br>
						</div>
			 	<div class="d-flex justify-content-end"><button class="btn btn-secondary">등록</button></div>
		</form:form>
  <div>
  	<input type="checkbox" id="test" value="테스트">테스트
  </div>
  
  		<div class="row my-5">
  			<div class="col-lg-12">
  				<div class="card">
  					<div class="card-header">
  						<h4>파일 첨부</h4>	
  					</div>
  					<div class="card-body">
  						<div class="form-group uploadDiv">
  							<input type="file" name="uploadFile" multiple>
  						</div>
  						<div class="uploadResult">
  							<ul class="list-group">
  							</ul>
  						</div>
  					</div> <!-- panel body -->
  				</div> <!-- panel end-->
  			</div><!-- col end -->
  		</div><!-- row end -->
  
  </div><!-- container end -->
  
  <script type="text/javascript">

		let regex = new RegExp("(.*?)\.(exe|sh|js|alz)$"); //정규표현식
		let maxSize = 5242880; //5mb
		
		function checkExtension(fileName, fileSize) {
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(fileName)){
				alert("지원하지 않는 확장자")
				return false;
			}
			return true;
		}
		
  
		let uploadResult = $('.uploadResult ul');
		function showUploadResult(uploadResultArr) {
			
			if(!uploadResultArr || uploadResultArr.length == 0) return;
			
			let str = "";
			$(uploadResultArr).each(function(i, obj){
				if(!obj.fileType){ // 이미지가 아닌경우
					// 파일 경로
					let fileCellPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
					let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
				
					// 파일이름에 다운로드 링크걸기!
				
					str += "<li class='list-group-item' data-path=' "+obj.uploadPath+"' ";
					str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
					str += "<img src = '${pageContext.request.contextPath}/resources/images/attach.png' style='width:30px'>"
					str += "<a href='${pageContext.request.contextPath}/download?fileName=" + fileCellPath +" '>" + obj.fileName  +"</a>"
					str += "<div class='d-flex justify-content-end'><span data-file='"+fileLink+"'  data-type='file'> 삭제 </span></div>"
					str += "</li>"
					
				} else{//이미지 인 경우
					//파일경로
					let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
					let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
					let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
					originPath = originPath.replace(new RegExp(/\\/g),"/");
					
				str += "<li class='list-group-item' data-path='"+obj.uploadPath+"'";
				str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";	
				str += " <img src = '${pageContext.request.contextPath}/display?fileName="+fileCellPath+"'>"
				str += " <a href='javascript:showImage(\""+originPath+"\")'>이미지 원본보기</a>"
				str += "<br><div class='d-flex justify-content-end'><span data-file='"+fileLink+"'  data-type='image'> 삭제 </span></div>"
				str += "</li>"
				}
			})
			uploadResult.append(str);
		}
		
		
		
		$(function() {
			let form = $('#registerForm');
			let submitBtn = $('#registerForm button');
			
			// 기본동작 금지하는 펑션(prevent)
			 submitBtn.on('click', function (e) {
				e.preventDefault();
				let str ='';
				
				$('.uploadResult ul li').each(function (i, obj) {
					let jobj = $(obj);
					console.log(jobj.data('filename'));
					
					str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data('filename')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data('uuid')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data('path')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data('type')+"'>";
				});
				form.append(str).submit();
			 })
				
		
			
			//파일 업로드
			$('input[type="file"]').change(function(e) {
				let formData = new FormData();
				let inputFiles = $('input[name="uploadFile"]');
				let files = inputFiles[0].files;
				
				for(let f of files){
					if(!checkExtension(f.name, f.size))	return false;
					formData.append('uploadFile', f)
				}
				
				$.ajax({
					url : contextPath + '/uploadAjaxAction',
					type : 'post',
					processData : false,
					contentType : false,
					data : formData,
					dataType : 'json',
					success : function(result) {
						showUploadResult(result);
					}
				})
			})
			
			let checked= false;
			$('#test').on('change', function() {
				if(!checked){
					checked=true;
				alert('쳌쳌');
				}else{
					checked = false;
					alert('쳌쳌 해제' );
				}
			})
			
			// 삭제 이벤트 설정
			$('.uploadResult ul').on('click', 'span', function() {
				alert('삭제');
				let targetFile = $(this).data('file');
				let type = $(this).data('type');
				let targetLi = $(this).closest('li');
				
				$.ajax({
					url : contextPath + '/deleteFile',
					type : 'post',
					data : {fileName : targetFile, type : type},
					dataType : 'text',
					success : function(result) {
						alert(result);
						targetLi.remove();
						
					}
				})
				
			})
			
			
		}) /* document end */
</script>
  
  
		  <style>
			  .error{font-size:20px; color:red;}  
		  </style>


			
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
