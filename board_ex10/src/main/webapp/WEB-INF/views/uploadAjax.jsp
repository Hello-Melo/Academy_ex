<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <%@ include file="/WEB-INF/views/layout/header.jsp" %>
<style>
.oImg img {width : 500px;}
</style>


		<h2>파일 업로드</h2>
		<div class="uploadDiv">
			<input type="file" name="uploadFile" multiple>
		</div>
		
			<button id="uploadBtn">submit</button>
		
		<div class="uploadResult">
				<ul>
						
				
				</ul>
				<div class="oImg">
	
				</div>
		</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

	$(document).ready(function() {
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
		
		let cloneObj = $('.uploadDiv').clone();
		
		$('#uploadBtn').on('click', function(e) {
			let formData = new FormData();
			let inputFile = $("input[name='uploadFile']");
			let files = inputFile[0].files;
			console.log(files);
			
			for(let i = 0 ; i < files.length ; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
				url : contextPath + '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'post',
				success : function(result) {
					alert('uploaded');
					
					$('.uploadDiv').html(cloneObj.html());
					showUploadFile(result);
				}
			})
			
		})
		
		let uploadResult = $('.uploadResult ul');
		function showUploadFile(uploadResultArr) {
			let str = "";
			$(uploadResultArr).each(function(i, obj){
				if(!obj.image){ // 이미지가 아닌경우
					// 파일 경로
					let fileCellPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
					let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
				
					// 파일이름에 다운로드 링크걸기!
					str += "<li> <img src = '${pageContext.request.contextPath}/resources/images/attach.png' style='width:30px'>"
					str += "<a href='${pageContext.request.contextPath}/download?fileName=" + fileCellPath +" '>" + obj.fileName  +"</a>"
					str += "<span data-file='"+fileLink+"'  data-type='file'> 삭제 </span>"
					
					str += "</li>"
					
				} else{//이미지 인 경우
					//파일경로
					let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
					let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
					let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
					originPath = originPath.replace(new RegExp(/\\/g),"/");
					console.log(originPath)
				str += " <li><img src = '${pageContext.request.contextPath}/display?fileName="+ fileCellPath+"'>"
				str += " <a href='javascript:showImage(\""+originPath+"\")'>이미지 원본보기</a>"
				str += "<br><span data-file='"+fileLink+"'  data-type='image'> 삭제 </span>"
				str += "</li>"
				}
			})
			uploadResult.append(str);
		}
		
		
		uploadResult.on('click', 'span', function(e) {
			console.log($(this).data('file'));
			alert('삭제 가즈아');
			
			let targetFile = $(this).data("file");
			let type = $(this).data("type");
			
			$.ajax({
				url :  contextPath + '/deleteFile',
				data : {fileName : targetFile, type : type},
				dataType : 'text',
				type : 'POST',
				success : function(result) {
					alert(result);
					}
			});
		});
	})//document.ready()  end;
	
	
	function showImage(path) {
			let imgTag = "<img  src='${pageContext.request.contextPath}/display?fileName=" + encodeURI(path) + "'>"
			$('.oImg').html(imgTag);
		}
		
	
</script>


</body>
</html>