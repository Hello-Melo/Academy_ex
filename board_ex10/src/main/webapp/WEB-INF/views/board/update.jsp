<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="container">
	<h2>글 내용 수정</h2>

	<form action="${pageContext.request.contextPath}/board/update" method="post" enctype="multipart/form-data" id="modifyForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
		<input type="hidden" name="bno" value="${param.bno}">
		제목 : <input type="text" name="title" value="${param.title}"><br>
		작성자 : <input type="text" name="writer" value="${param.writer}"><br>
		내용 :	<textarea name="contents" id="contents"  ></textarea>

		<br>

		<button>글 수정</button>
	</form>

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



</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	<script>
		
	function showUploadResult(uploadResultArr) {
		
		if(!uploadResultArr || uploadResultArr.length == 0) return;
		
		let str = "";
		$(uploadResultArr).each(function(i, obj){
			if(!obj.fileType){ // 이미지가 아닌경우
				// 파일 경로
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
			
				// 파일이름에 다운로드 링크걸기!
			
				str += "<li class='list-group-item' data-path='"+obj.uploadPath+"'";
				str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
				str += "<img src = '"+contextPath+"/resources/images/attach.png' style='width:30px'>"
				str += "<span>" + obj.fileName + "</span>"
				str += "<div class='d-flex justify-content-end'><span data-file='"+fileLink+"'  data-type='file'> 삭제 </span></div>"
				str += "</li>"
				
			} else{//이미지 인 경우
				//파일경로
				
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				console.log(fileCellPath);
				let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
				let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
				
			str += "<li class='list-group-item' data-path='"+obj.uploadPath+"'";
			str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";	
			str += " <img src = '"+contextPath+"/display?fileName="+fileCellPath+"'>"
			str += "<span>" + obj.fileName + "</span>"
			str += "<div class='d-flex justify-content-end'><span data-file='"+fileLink+"'  data-type='image'> 삭제 </span></div>"
			str += "</li>"
			}
		})
		$('.uploadResult ul').append(str);
	}
	
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
		
		//ckEditor 불러오기 + 파일업로드!
		$(function () {
				CKEDITOR.replace('contents', {
					filebrowserUploadUrl : '${pageContext.request.contextPath}/adm/fileupload.do'
				});
		});
		
		
		$(function() {
			let bnoValue = "${param.bno}";
			$.getJSON(contextPath+"/board/getAttachList", {bno : bnoValue}, function(attachList) {
				showUploadResult(attachList);
			}) //getJSON end
			
			
				// 삭제 이벤트 설정
			$('.uploadResult ul').on('click', 'span', function() {
				alert('삭제');
				let targetLi = $(this).closest('li');
				targetLi.remove();
			}) //delete end
			
			
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
			}) //change event end			
			
			
			let modifyForm =$('#modifyForm');
			let modifyBtn = $('#modifyForm button');
			modifyBtn.on('click', function (e) {
				e.preventDefault();
				//console.log('멈춰!');
				let str = "";
				$('.uploadResult ul li').each(function(i, obj) {
					let jobj = $(obj);
					str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data('filename')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data('uuid')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data('path')+"'>";
					str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data('type')+"'>";
				})
				modifyForm.append(str).submit();
			})
			
			
		})
		
		</script>